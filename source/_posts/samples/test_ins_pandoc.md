---
title: Pandoc General Howto
date: 2021-07-10 20:20:20
tags:
---

## Pandoc General Howto

[TOC]

### My Pandoc pdf latex workflow



### Some links to tutorials

Here are some tutorials on basic usage or how to use Pandoc commands.
This is the [pandoc demos](https://pandoc.org/demos.html) page.

A tutorial on [basic make use](https://kbroman.org/minimal_make/).

A make file starter [github repo](https://github.com/kjhealy/md-starter).

Some explanation on the make files using Pandoc at thes [post](https://plain-text.co/pull-it-together.html#pull-it-together).

This [tutorial on sustainable authorship in plan text](https://plain-text.co/pull-it-together.html#pull-it-together) seems to be a good one.  

[learnbyexample](https://github.com/learnbyexample/learnbyexample.github.io/tree/master/files/pandoc_pdf) repo seems to have some sh scripts for Pandoc, as shown in the [post](https://learnbyexample.github.io/customizing-pandoc/). 

### Examples

#### pandoc command examples

##### Metadata ymal

csl and bibliography is needed for citation using the command below. csl specifies style and can be downloaded from like this [official citation style language repo](https://github.com/citation-style-language/styles).

```yaml
bibliography: curr_zotero_bibtex2021.bib
csl: curr_zotero_CSL_JSON2021.json
link-citations: true
toc: true
```

-C (or —citeproc) is needed for processing citations. 

```bash
-f markdown -t latex -s -o currTest.pdf -C pandocTestcopy.md
```

```bash
pandoc "document.md" -o "elegantTest2.pdf" --from markdown --listings --top-level-division="chapter" -s
```

With the following for book document.md

```yaml
title: "Example PDF"
author: [Author]
documentclass: elegantbook
date: "2017-02-20"
subject: "Markdown"
keywords: [Markdown, Example]
book: true
classoption: [oneside]
toc: true
lof: true
lot: true
```

For a folder content and there are several md files.

```bash
pandoc -s -N --biblatex --listings --top-level-division=chapter --template=template.tex metadata.md content/*.md -o $1.tex
```

Comment: I thin $1 here is for the first argument.

This is a quick java code:

```java
public class MyTest
{
  public static void main(String[] args)
  {
    int i = 8;
    int j = 10;
    String s1 = "this is a string1";
    System.out.println("this is s1: "+s1);
  }
  public static int myMethod(String s1)
  {
    if(s1.equals("s1"))
      return 0;
    return 1;
  }
}
```



##### Beamer commands examples

```
pandoc "document.md" -o "mydocument.pdf" --from markdown --to beamer --template "../../eisvogel.tex" --listings
```

#### Make pdf books

The pandoc-book-template-master file contains a Makefile that has a workflow of run pandoc commands using make.  And it complies everything in the chapters directory and make a book. Build a book under a directory build/book. It looks like it supports other (them, docx) file formats. I added latex format. 

Now, to use the elegantbook style, generate the latex file using `make latex` and open the resulting file and manually change the document class variable/settings. Looks like removing the unicode character error, it will generate the book with elegantbookstyle.

Also, using the pandoc on the command line on the resulting latex file will generate a pdf book but not using the document class elgantbook (maybe setting it on the command line will work?).

##### Include sub files

It turns out that at least I can use raw latex \include command, but the files need to be in tex format without standalone format. Then run the index.md with a bunch of include will work.



##### Markdown Testing 1

This is a footnote^[implicite footnote]. But not sure the **previous** will *work* ***because*** it’s not ==provided== later. This should work[^f1] fine. Footnote should be of the same name. Some ^superscript^ and ~subscript~. And this is a comment <!--cut--> is the **previous** cut comment skipped? Citation [@agarwal_neural_2020] and multiple author [@alguliev_multiple_2013; @allahyari_text_2017; @anchieta_sema_2019]. Should work.

And ~~some~~ more texts. Also in text citation @anchieta_sema_2019 says something.

Some maths inline $x^2+y^2=z^2$ and math mode:
$$
x^2+\frac{y}{x+1}-\alpha+\beta+\sigma=f(x)
$$
The above is a math.

This links to a file [lingtoafile](pandocTestOtherspecs.md). Ok. It’s working in pdf as well. If I put [] and (filename.ext) this will open filename.ext in the pdf file as well. If I put an absolute path not working,

This is a file link to a file in the subfolder [subfile](subfolder/sub.md). And this is a file from one level up parent folder [level1Parent](../parent1/parent1file.md). How about these. **In markdown file, links to files are working.** **In pdf file on computer, sublevel reference link is working, but not parent folders.**
This is a Devon link to the [lingtoafile](x-devonthink-item://C8B5309D-8F2D-4AD3-B1BF-B7C98C974210). Check it. To [another Devon file](x-devonthink-item://C6C02A59-AE29-4EBC-81D5-4CC2928EA991). Ok.
Besides using devon think link, use double brackets now [[pandocTestOtherspecs]] and it is woking. Another one [[MyBeamerPresentations]].

Extension: task_lists

Pandoc supports task lists, using the syntax of GitHub-Flavored Markdown.

- [ ] an unchecked task list item
- [x] checked item

Pandoc supports deﬁnition lists, using the syntax of PHP Markdown Extra with some extensions.2 



[^f1]: this is f1 footnote.

### Usage Basics

##### Input output, -o -s

If no *input-files* are specified, input is read from *stdin*. Output goes to *stdout* by default. For output to a file, use the -o option:

```
pandoc -o output.html input.txt
```

By default, pandoc produces a document fragment. To produce a standalone document (e.g. a valid HTML file including <head> and <body>), use the -s or --standalone flag:

```
pandoc -s -o output.html input.txt
```

This option is set automatically for pdf, epub, epub3, fb2, docx, and odt output.

If multiple input files are given, pandoc will concatenate them all (with blank lines between

them) before parsing. (Use --file-scope to parse files individually.)

##### From to

The input format can be specified using the -f/--from option, the output format using the -t/--to option. Thus, to convert hello.txt from Markdown to LaTeX, you could type: 

```
pandoc -f markdown -t latex hello.txt
```

You can also use pandoc --list-input-formats and pandoc --list-output-formats to print lists of supported formats.

##### Create PDF

To produce a PDF, specify an output file with a .pdf extension:

```
pandoc test.txt -o test.pdf
```

Or we can use the pdf engines. To do this, specify an output file with a .pdf extension, as before, but add the --pdf-engine option or -t context, -t html, or -t ms to the command line. The tool used to generate the PDF from the intermediate format may be specified using --pdf-engine.

##### Data directory

--data-dir=DIRECTORY Specify the user data directory to search for pandoc data ﬁles. If this option is not speciﬁed, the default user data directory will be used.

You can ﬁnd the default user data directory on your system by looking at the output of pandoc --version. Data ﬁles placed in this directory (for example, reference.odt, reference.docx, epub.css, templates) will override pandoc’s normal defaults.

##### Suppress warning messages

--quiet Suppress warning messages.

##### Shift document heading

--shift-heading-level-by=NUMBER Shift heading levels by a positive or negative in-

teger. For example, with --shift-heading-level-by=-1, level 2 headings become level 1 headings, and level 3 headings become level 2 headings. Headings cannot have a level less than 1, so a heading that would be shifted below level 1 becomes a regular paragraph.

--base-header-level=NUMBER Deprecated.

Use --shift-heading-level-by=X instead, where X = NUMBER 1. Specify the base level for headings (defaults to 1).

##### Ignore empty paragraphs

--strip-empty-paragraphs Deprecated. Use the +empty_paragraphs extension instead. Ig-

nore paragraphs with no content. This option is useful for converting word processing documents where users have used empty paragraphs to create inter-paragraph space.

##### filters

-F PROGRAM, --filter=PROGRAM Specify an executable to be used as a ﬁlter transforming the pandoc AST after the input is parsed and before the output is written. The executable should read JSON from stdin and write JSON to stdout. The JSON must be formatted like pandoc’s own JSON input and output. The name of the output format will be passed to the ﬁlter as the ﬁrst argument. Hence,

pandoc --filter ./caps.py -t latex

is equivalent to

pandoc -t json | ./caps.py latex | pandoc -f json -t latex

Filters may be written in any language. Those who would prefer to write ﬁlters in python can use the module pandocfilters, installable from PyPI.

-L SCRIPT, --lua-filter=SCRIPT Transform the document in a similar fashion as JSON ﬁlters (see --filter), but use pandoc’s built-in Lua ﬁltering system.

##### Metadata key value

-M KEY[=VAL], --metadata=KEY[:VAL] Set the metadata ﬁeld KEY to the value VAL. A

value speciﬁed on the command line overrides a value speciﬁed in the document using YAML metadata blocks. Values will be parsed as YAML boolean or string values.

--metadata-file=FILE Read metadata from the supplied YAML (or JSON) ﬁle.

##### Extract media

--extract-media=DIR Extract images and other media contained in or linked from the source document to the path DIR, creating it if necessary, and adjust the images references in the document so they point to the extracted ﬁles. Media are downloaded, read from the ﬁle system, or extracted from a binary container (e.g. docx), as needed. The original ﬁle paths are used if they are relative paths not containing ... Otherwise ﬁlenames are constructed from the SHA1 hash of the contents.

##### Table of contents depth

--toc-depth=NUMBER Specify the number of section levels to include in the table of contents. The default is 3 (which means that level-1, 2, and 3 headings will be listed in the contents).

##### Code highlight style

--highlight-style=STYLE|FILE Speciﬁes the coloring style to be used in highlighted source code. Options are pygments (the default), kate, monochrome, breezeDark,

espresso, zenburn, haddock, and tango. See also --list-highlight-styles.

##### Top level dividion

--top-level-division=default|section|chapter|part Treat top-level headings as the

given division type in LaTeX, ConTeXt, DocBook, and TEI output. The hierarchy order is part, chapter, then section; all headings are shifted such that the top-level heading becomes the speciﬁed type. The default behavior is to determine the best division type via heuristics: unless other conditions apply, section is chosen. When the documentclass variable is set to report, book, or memoir (unless the article option is speciﬁed), chapter is implied as the setting for this option. If beamer is the output format, specifying either chapter or part will cause top-level headings to become \part{..}, while second-level headings remain as their default type.

##### Number sections

-N, --number-sections Number section headings in LaTeX, ConTeXt, HTML, Docx, ms, or EPUB output. By default, sections are not numbered. Sections with class unnumbered will never be numbered, even if --number-sections is speciﬁed.



##### Slide level beamer, etc

--slide-level=NUMBER Speciﬁes that headings with the speciﬁed level create slides (for beamer, s5, slidy, slideous, dzslides). Headings above this level in the hierarchy are used to divide the slide show into sections; headings below this level create subheads within a slide. Note that content that is not contained under slide-level headings will not appear in the slide show. The default is to set the slide level based on the contents of the document; see Structuring the slide show.

##### Ipynb output

--ipynb-output=all|none|best Determines how ipynb output cells are treated.

all

means that all of the data formats included in the original are preserved. none means that the contents of data cells are omitted. best causes pandoc to try to pick the richest data block in each output cell that is compatible with the output format. The default is best.

##### Template

When the -s/--standalone option is used, pandoc uses a template to add header and footer material that is needed for a self-standing document.

A custom template can be speciﬁed using the --template option. You can also override the system default templates for a given output format FORMAT by putting a ﬁle templates/default.*FORMAT* in the user data directory (see --data-dir, above).

##### Headings unnumbered

```
Headings with the class unnumbered will not be numbered, even if --number-sections is speciﬁed. A single hyphen (-) in an attribute context is equivalent to .unnumbered, and preferable in non-English documents. So,

# My heading {-}

is just the same as

# My heading {.unnumbered}
```

##### Rebase relative paths

```
Extension: rebase_relative_paths

Rewrite relative paths for Markdown links and images, depending on the path of the ﬁle containing the link or image link. For each link or image, pandoc will compute the directory of the containing ﬁle, relative to the working directory, and prepend the resulting path to the link or image path.

The use of this extension is best understood by example. Suppose you have a a subdirectory for each chapter of a book, chap1, chap2, chap3. Each contains a ﬁle text.md and a number of images used in the chapter. You would like to have ![image](spider.jpg) in chap1/text.md refer to chap1/spider.jpg and ![image](spider.jpg) in chap2/text.md

refer to chap2/spider.jpg. To do this, use

pandoc chap*/*.md -f markdown+rebase_relative_paths

Without this extension, you would have to use ![image](chap1/spider.jpg) in chap1/text.md and ![image](chap2/spider.jpg) in chap2/text.md. Links with rel-

ative paths will be rewritten in the same way as images.

Absolute paths and URLs are not changed. Neither are empty paths or paths consisting entirely of a fragment, e.g., #foo.

Note that relative paths in reference links and images will be rewritten relative to the ﬁle containing the link reference deﬁnition, not the ﬁle containing the reference link or image itself, if these differ.
```

##### Citations in note style

Pandoc’s citation processing is designed to allow you to move between author-date, numerical, and note styles without modifying the markdown source. When you’re using a note style, avoid inserting footnotes manually. Instead, insert citations just as you would in an author-date style—for example,

Blah blah [@foo, p. 33].

The footnote will be created automatically. Pandoc will take care of removing the space and moving the note before or after the period, depending on the setting of notes-afterpunctuation, as described below in Other relevant metadata ﬁelds.

In some cases you may need to put a citation inside a regular footnote. Normal citations in footnotes (such as [@foo, p. 33]) will be rendered in parentheses. In-text citations (such as @foo [p. 33]) will be rendered without parentheses. (A comma will be added if appropriate.) Thus:

```
[^1]: Some studies [@foo; @bar, p. 33] show that frubulicious zoosnaps are quantical. For a survey of the literature, see @baz [chap. 1].
```

##### link citations

link-citations If true, citations will be hyperlinked to the corresponding bibliography entries (for author-date and numerical styles only).

### Pandoc Markdown

##### lists

You can use the same trick if you want two consecutive lists instead of one big list:

1. one

2. two

3. three

<!-- -->

1. uno

2. dos

3. tres

##### Task lists {#task_lists_with_id}

Extension: task_lists

Pandoc supports task lists, using the syntax of GitHub-Flavored Markdown.

```
Extension: task_lists

Pandoc supports task lists, using the syntax of GitHub-Flavored Markdown.

- [ ] an unchecked task list item

- [x] checked item
```

- [ ] an unchecked task list item

- [x] checked item

##### Definition lists

```
Pandoc supports deﬁnition lists, using the syntax of PHP Markdown Extra with some extensions.2 

Term 1

:

Definition 1

Term 2 with *inline markup*

:

Definition 2

{ some code, part of Definition 2 }

Third paragraph of definition 2.
```

If you leave space before the deﬁnition (as in the example above), the text of the deﬁnition will be treated as a paragraph. In some output formats, this will mean greater spacing between term/deﬁnition pairs. For a more compact deﬁnition list, omit the space before the deﬁnition:

Term 1 

​	~ Definition 1

Term 2

​	~ Definition 2a 

​	~ Definition 2b

##### Example lists

Extension: example_lists

The special list marker @ can be used for sequentially numbered examples. The ﬁrst list item with a @ marker will be numbered ‘1’, the next ‘2’, and so on, throughout the document. The numbered examples need not occur in a single list; each new list using @ will take up where the last stopped. So, for example:

```
(@) My first example will be numbered (1). 
(@) My second example will be numbered (2).

Explanation of examples.

(@) My third example will be numbered (3).

Numbered examples can be labeled and referred to elsewhere in the document:

(@good) This is a good example.

As (@good) illustrates, ...

The label can be any string of alphanumeric characters, underscores, or hyphens.
```

##### verbatim

To make a short span of text verbatim, put it inside backticks:

What is the difference between `>>=` and `>>`?

If the verbatim text includes a backtick, use double backticks:

Here is a literal backtick `` ` ``.

```
What is the difference between `>>=` and `>>`?

If the verbatim text includes a backtick, use double backticks:

Here is a literal backtick `` ` ``.
```

##### shortcut reference links

Extension: shortcut_reference_links

In a shortcut reference link, the second pair of brackets may be omitted entirely:

```
See [my website].

[my website]: http://foo.bar.baz
```

##### internal links

```
To link to another section of the same document, use the automatically generated identiﬁer (see Heading identiﬁers). For example:

See the [Introduction](#introduction).

or

See the [Introduction].

[Introduction]: #introduction

Internal links are currently supported for HTML formats (including HTML slide shows and EPUB), LaTeX, and ConTeXt.
```

##### images

```
A link immediately preceded by a ! will be treated as an image. The link text will be used as the image’s alt text:

![la lune](lalune.jpg "Voyage to the moon")

![movie reel]

[movie reel]: movie.gif

If you just want a regular inline image, just make sure it is not the only thing in the paragraph. One way to do this is to insert a nonbreaking space after the image:
![This image won't be a figure](/url/of/image.png)\

![](file.jpg){ width=50% }
```

##### Image links 

```
![textsum_types](media/contents/textsum_types.png){#fig:textsum_types width=90% height=60%}
```

The % unit is generally relative to some available space. For example the above example will render to the following.

– LaTeX: \includegraphics[width=0.5\textwidth,height=\textheight]{file.jpg}

(If you’re using a custom template, you need to conﬁgure graphicx as in the default template.)

```
For immediate example, see @fig:figure0

![Figure Caption](img1.jpg){#fig:figure0}

reference it as [Fig. @fig:figure0] will show Fig. 1
```



##### Incremental lists (beamer)

If you want a particular list to depart from the default, put it in a div block with class incremental or nonincremental. So, for example, using the fenced div syntax, the following would be incremental regardless of the document default:

```
::: incremental

- Eat spaghetti

- Drink wine

:::

or

::: nonincremental

- Eat spaghetti
- Drink wine

:::
```



##### fenced divs

Allow special fenced syntax for native Div blocks. A Div starts with a fence containing at least three consecutive colons plus some attributes. The attributes may optionally be followed by another string of consecutive colons.

```
::::: {#special .sidebar} 
Here is a paragraph.

And another. 
:::::
```

Fenced divs can be nested. Opening fences are distinguished because they must have attributes:

```
::: Warning :::::: This is a warning.

::: Danger This is a warning within a warning. :::

::::::::::::::::::
```

##### footnotes

Inline footnotes are also allowed (though, unlike regular notes, they cannot contain multiple paragraphs). The syntax is as follows:

Here is an inline note.^[Inlines notes are easier to write, since you don't have to pick an identifier and move down to type the note.]

##### citations

Citation [@agarwal_neural_2020] and multiple author [@alguliev_multiple_2013; @allahyari_text_2017; @anchieta_sema_2019]. Should work.

And ~~some~~ more texts. Also in text citation @anchieta_sema_2019 says something.

Separate multiple citations using ;

Also, add -C or —citeproc as an argument.

##### multicolumns

See this [github doc](https://github.com/jdutant/columns).

### Pandoc Filter pandoc crossref

##### Some documentation links

This is the official doc: [pandoc-crossref(1) | pandoc-crossref](https://lierdakil.github.io/pandoc-crossref/#image-labels).



Some maths inline $x^2+y^2=z^2$ and math mode:
$$
x^2+\frac{y}{x+1}-\alpha+\beta+\sigma=f(x)
$$
The above is a math.

