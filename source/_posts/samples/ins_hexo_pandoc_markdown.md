---
title: Ins Hexo Pandoc Markdown
date: 2021-10-10 19:04:01
tags:
---

### FirstH3

This should be the top text.

### This is a header3

And let’s try some texts

This is an inline $x^2+y=f(x)$ and another inline $\frac{a}{b}+x_1+\alpha*b+\omega*x_i$ and.
$$
\begin{equation}\label{eq1}
f(x)=\frac{a}{b}+x_1+\alpha*b+\omega*x_i
\end{equation}
$$
End of lines.
$$
\begin{equation}\label{eq2}
\begin{aligned}
a &= b + c \\
  &= d + e + f + g \\
  &= h + i
\end{aligned}
\end{equation}
$$
Ends.

### AnotherHeader3

Another formular (note that this formula is not using `\begin{equation}` so it’s not numbered when the mathjax setting tags: ams is set.)
$$
i\hbar\frac{\partial}{\partial t}\psi=-\frac{\hbar^2}{2m}\nabla^2\psi+V\psi
$$
And Latex code: (I used `\begin{eqnarray*}` to ignore the equation numbers, without the asterisk symbol it will number each equation below)
$$
\begin{eqnarray*}
\nabla\cdot\vec{E}&=&\frac{\rho}{\epsilon_0}\\\\
\nabla\cdot\vec{B}&=&0\\\\
\nabla\times\vec{E}&=&-\frac{\partial B}{\partial t}\\\\
\nabla\times\vec{B}&=&\mu_0\left(\vec{J}+\epsilon_0\frac{\partial E}{\partial t}\right)\\\\
\end{eqnarray*}
$$
OK, now that I have a few labels, I’ll refer to equation 1 as  `$\eqref{eq1}$` like this Eq. $\eqref{eq1}$ And more. And eq2 as $\eqref{eq2}$ Over.

Thesis a reference to [hello-world](./hello-world.md#testheaderref) file to the TestHeaderRef header.

**What if there’s a white space between letters in the file name?**

~~This links to the [./test_ins_pandoc.md#task_lists](./test_ins_pandoc.md#task%lists) with the header `Task lists`. Because there’s a space, not working.~~

### Reference to other sections in the same file

This [#firsth3](#firsth3) points to the header `FirstH3`.

Now cross ref to the first h3 as [the name of the first h3](#firsth3) part.

### Cross reference to other files with anchor

This [./test_ins_pandoc.md#filters](./test_ins_pandoc.md#filters) points to the `test_ins_pandoc.md` file at the section `filters`.

This [./test_ins_pandoc.md#task_lists_with_id](./test_ins_pandoc.md#task_lists_with_id) points to the file `test_ins_pandoc` in the same folder as the current file at section with manually set id `### Task lists {#task_lists_with_id}`. 

### Images

![With increasing penalty of the weights, fewer and fewer features receive a non-zero weight estimate. These curves are also called regularization paths. The number above the plot is the number of non-zero weights.](https://christophm.github.io/interpretable-ml-book/images/lasso-path-1.png)



One line of code.
