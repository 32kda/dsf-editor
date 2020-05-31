## DSFEditor
DSFEditor is a plugin for IntelliJ IDEA aimed at providing IDE supposrt for X-Plane Scenery DSF format

### Some implementation notes

Implementation is based on the [Custom language support](https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html) tutorial
IntelliJ have petty clear and powerful, but unfortunately poorly-documented custom language API. So, some implementation note would go below

#### Go To Declaration/References

Implementation is based on [this article](https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/reference_contributor.html).
DSF file has possible polygon classes (e.g. forests, building facades etc.) and objects list in it's header, which are linked below (using line index in this definition list) when placing concrete polygons and object instances on the map.
One of the key features for my plugin is an ability to click this int index and go to line, defining corresponding object or polygon.

Maybe I've missed smth, but initially it refused to work for me. After some research, I've found a following note for the _PsiReferenceContributor_ class:

```
Note that, if you're implementing a custom language, it won't by default support references registered through PsiReferenceContributor.
If you want to support that, you need to call
{@link com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry#getReferencesFromProviders(PsiElement)} from your implementation
of PsiElement.getReferences().
``` 
I've done this using method injection in _DSF.bnf_ file and a method _getReferences()_ in _DSFPsiUtil_ class. 
Read more [here](https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/psi_helper_and_utilities.html) on how to "inject" additional methods into the generated PSI element classes.

Besies that, _ReferenceContributor_ wasn't called for _DSFIntRef_ Psi Tree node, for which I wanted to create a link for.
I needed to re-register it to _PlatformPatterns.psiElement(PsiElement.class)_ pattern and after that - check, whether passed PSI Element has a _DSFIntRef_ as a child.
Please look at _com.onpositive.dsfedit.language.DSFReferenceContributor_ and _com.onpositive.dsfedit.language.DSFReference_ classes for the details

#### Showing additional line information in-editor

Another thing I wanted to achive is showing some tooltips for current line of code in editor itself, like it's done on the debug for variable values.
After some googling and searching existing projects for examples, I've found that I need to use the `editor.linePainter` extension point for this.
More information could be found in [this thread](https://intellij-support.jetbrains.com/hc/en-us/community/posts/360002834320-How-to-achieve-inline-values-similar-to-debugger-).

See an example in _DSFEditorLinePainter_ class

  
 

 