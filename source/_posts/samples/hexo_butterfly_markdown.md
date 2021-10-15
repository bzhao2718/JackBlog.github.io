---
title: Hexo Butterfly Markdown Examples
date: 2021-10-10 19:04:01
tags:
  - TestMarkdown
  - TutorialTest
categories: 
  MyMdCategory
keywords: "myMdTest, testTutorial"
bibliography: referenceAll.bib
link-citations: true
---

### FirstH3

This should be the top text.

This is a link a gif using pCloud share link:

![image using pCloud link](https://c466.pcloud.com/dpZWXyAhnZoz5ObwZUqBNZ7Zrkuki7Z3VZZmRHZZTxPRSbrJfeBvwfii41HT0pQfUFL7/image-20210807143253863.png)

### This is a header3

And let’s try some texts

This is a footnote inline [^f1]

This is an inline $x^2+y=f(x)$ and another inline $\frac{a}{b}+x_1+\alpha*b+\omega*x_i$ and.
```
\begin{equation}\label{eq1}
f(x)=\frac{a}{b}+x_1+\alpha*b+\omega*x_i
\end{equation}
```



End of lines.
```
\begin{equation}\label{eq2}
\begin{aligned}
a &= b + c \\
  &= d + e + f + g \\
  &= h + i
\end{aligned}
\end{equation}
```



Ends.

[^f1]: this is footnote1.

### AnotherHeader3

Another formular (note that this formula is not using `\begin{equation}` so it’s not numbered when the mathjax setting tags: ams is set.)
```
i\hbar\frac{\partial}{\partial t}\psi=-\frac{\hbar^2}{2m}\nabla^2\psi+V\psi
```



And Latex code: (I used `\begin{eqnarray*}` to ignore the equation numbers, without the asterisk symbol it will number each equation below)
```
\begin{eqnarray*}
\nabla\cdot\vec{E}&=&\frac{\rho}{\epsilon_0}\\\\
\nabla\cdot\vec{B}&=&0\\\\
\nabla\times\vec{E}&=&-\frac{\partial B}{\partial t}\\\\
\nabla\times\vec{B}&=&\mu_0\left(\vec{J}+\epsilon_0\frac{\partial E}{\partial t}\right)\\\\
\end{eqnarray*}
```



```
OK, now that I have a few labels, I’ll refer to equation 1 as  `$\eqref{eq1}$` like this Eq. $\eqref{eq1}$ And more. And eq2 as $\eqref{eq2}$ Over.
```



### The link problem solved!

Use double dot instead of a single dot. Also, when referencing an achor point, add a slash after the file name, and don’t add file type extension.

Thesis a reference to [../hello-world/#testheaderref](../hello-world/#testheaderref) file to the TestHeaderRef header.

This is a hard code link: [hard coded url](http://localhost:4000/JackBlog.github.io/samples/hello-world#testheaderref).

**What if there’s a white space between letters in the file name?**

Now to the [../test_ins_pandoc/#filters](../test_ins_pandoc/#filters) part.

~~This links to the [./test_ins_pandoc.md#task_lists](./test_ins_pandoc.md#task%lists) with the header `Task lists`. Because there’s a space, not working.~~

This refers to the id [the same task list with id: ../test_ins_pandoc/#task_lists_with_id](../test_ins_pandoc/#task_lists_with_id) part. Yep, it’s working when add `Task lists {#task_lists_with_id}` manually set the id.

Now cross ref to the first h3 as [the name of the first h3](#firsth3) part.

Now refer to headers with spaces, I believe add `-` would work: [#this-is-a-header3](#this-is-a-header3).

{% blockquote %}
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque hendrerit lacus ut purus iaculis feugiat. Sed nec tempor elit, quis aliquam neque. Curabitur sed diam eget dolor fermentum semper at eu lorem.
{% endblockquote %}

Some text.

{% pullquote [class] %}
content
{% endpullquote %}



This is a block quote from pandoc markdown.

> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque hendrerit lacus ut purus iaculis feugiat. Sed nec tempor elit, quis aliquam neque. Curabitur sed diam eget dolor fermentum semper at eu lorem.





### Footnotes

These are footnotes test. So the following are using `inline footnote ^[footnote text]` to auto generate the footnote number:

This is an inline footnote ^[inline footnote.].

This is another inline footnote ^[inline footnote.].

This is one more inline footnote ^[inline footnote.].

### citations

Citation [@agarwal_neural_2020] and multiple author [@alguliev_multiple_2013; @allahyari_text_2017; @anchieta_sema_2019]. Should work.

And ~~some~~ more texts. Also in text citation @anchieta_sema_2019 says something.

Separate multiple citations using ;

Also, add -C or —citeproc as an argument.

Now citations as footnote:

This is cite author `@agarwal_neural_2020`  using `^[([@agarwal_neural_2020])]` in foot ^[([@agarwal_neural_2020])].

Now test another `^[@agarwal_neural_2020]` in foot ^[@agarwal_neural_2020].

Now add some text: in foot ^[in footnote @agarwal_neural_2020]. Now cite with explicit footnote [^cite1]

. And cite another with brackets [^cite2].

[^cite1]: with brackets [@agarwal_neural_2020]. 
[^cite2]: this is cite @agarwal_neural_2020 and over.





This is a list:

1. This is number1
2. This is number2
   1. This is subnumber2
   2. This is subnumber2
3. This is number 3



This is another list:

- What do you think
- This is a list
  - This is a sublist
  - This sis another sublist
- Another list

These are some instructions.
