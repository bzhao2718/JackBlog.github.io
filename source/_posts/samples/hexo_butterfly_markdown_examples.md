---
title: Hexo Butterfly Markdown Examples
date: 2021-10-10 19:04:01
tags:
  - TestMarkdown
  - TutorialTest
categories: 
  MyMdCategory
keywords: "myMdTest, testTutorial"
---

### FirstH3

This should be the top text.

This is a link a gif using pCloud share link:

![image using pCloud link](https://c466.pcloud.com/dpZWXyAhnZkWOczwZUqBNZ7ZHJw7i7Z3VZZmRHZZHs3TMxd1sF7iCEXrFxANmXEfQ0Fy/image-20210807143253863.png)

### This is a header3

And let’s try some texts

This is a footnote inline [^f1]

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

[^f1]: this is footnote1.

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

This is a hard code link: [hard coded url](http://localhost:4000/JackBlog.github.io/samples/hello-world.md#testheaderref).

**What if there’s a white space between letters in the file name?**

Now to the [./test_ins_pandoc.md#filters](./test_ins_pandoc.md#filters) part.

~~This links to the [./test_ins_pandoc.md#task_lists](./test_ins_pandoc.md#task%lists) with the header `Task lists`. Because there’s a space, not working.~~

This refers to the id [the same task list with id](./test_ins_pandoc.md#task_lists_with_id) part. Yep, it’s working when add `Task lists {#task_lists_with_id}` manually set the id.

Now cross ref to the first h3 as [the name of the first h3](#firsth3) part.

{% blockquote %}
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque hendrerit lacus ut purus iaculis feugiat. Sed nec tempor elit, quis aliquam neque. Curabitur sed diam eget dolor fermentum semper at eu lorem.
{% endblockquote %}

Some text.

{% pullquote [class] %}
content
{% endpullquote %}



This is a block quote from pandoc markdown.

> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque hendrerit lacus ut purus iaculis feugiat. Sed nec tempor elit, quis aliquam neque. Curabitur sed diam eget dolor fermentum semper at eu lorem.



这是关于的一个测试test(no space in front)，这是一个中文 Chinese character(with space in front)，然后这是一个英文 English(with space)，Now(without space)总的来说。

### Note box

This is a modern style note box.

```
{% note modern %}
默认 提示块标籤
{% endnote %}

{% note default modern %}
default 提示块标籤
{% endnote %}

{% note primary modern %}
primary 提示块标籤
{% endnote %}

{% note success modern %}
success 提示块标籤
{% endnote %}

{% note info modern %}
info 提示块标籤
{% endnote %}

{% note warning modern %}
warning 提示块标籤
{% endnote %}

{% note danger modern %}
danger 提示块标籤
{% endnote %}

```



{% note modern %}
默认 提示块标籤
{% endnote %}

{% note default modern %}
default 提示块标籤
{% endnote %}

{% note primary modern %}
primary 提示块标籤
{% endnote %}

{% note success modern %}
success 提示块标籤
{% endnote %}

{% note info modern %}
info 提示块标籤
{% endnote %}

{% note warning modern %}
warning 提示块标籤
{% endnote %}

{% note danger modern %}
danger 提示块标籤
{% endnote %}

Now these are fiat style:

```
{% note flat %}
默认 提示块标籤
{% endnote %}

{% note default flat %}
default 提示块标籤
{% endnote %}

{% note primary flat %}
primary 提示块标籤
{% endnote %}

{% note success flat %}
success 提示块标籤
{% endnote %}

{% note info flat %}
info 提示块标籤
{% endnote %}

{% note warning flat %}
warning 提示块标籤
{% endnote %}

{% note danger flat %}
danger 提示块标籤
{% endnote %}
```



{% note flat %}
默认 提示块标籤
{% endnote %}

{% note default flat %}
default 提示块标籤
{% endnote %}

{% note primary flat %}
primary 提示块标籤
{% endnote %}

{% note success flat %}
success 提示块标籤
{% endnote %}

{% note info flat %}
info 提示块标籤
{% endnote %}

{% note warning flat %}
warning 提示块标籤
{% endnote %}

{% note danger flat %}
danger 提示块标籤
{% endnote %}



These are without icons:

```
{% note no-icon %}
默认 提示块标籤
{% endnote %}

{% note default no-icon %}
default 提示块标籤
{% endnote %}

{% note primary no-icon %}
primary 提示块标籤
{% endnote %}

{% note success no-icon %}
success 提示块标籤
{% endnote %}

{% note info no-icon %}
info 提示块标籤
{% endnote %}

{% note warning no-icon %}
warning 提示块标籤
{% endnote %}

{% note danger no-icon %}
danger 提示块标籤
{% endnote %}

```

{% note no-icon %}
默认 提示块标籤
{% endnote %}

{% note default no-icon %}
default 提示块标籤
{% endnote %}

{% note primary no-icon %}
primary 提示块标籤
{% endnote %}

{% note success no-icon %}
success 提示块标籤
{% endnote %}

{% note info no-icon %}
info 提示块标籤
{% endnote %}

{% note warning no-icon %}
warning 提示块标籤
{% endnote %}

{% note danger no-icon %}
danger 提示块标籤
{% endnote %}

### Thes is tag-hide function

#### Inline hide

inline 在文本里面添加按钮隐藏内容，只限文字. ( content不能包含英文逗号，可用&sbquo;)

```markdown
{% hideInline content,display,bg,color %}
content: 文本内容

display: 按钮显示的文字(可选)

bg: 按钮的背景颜色(可选)

color: 按钮文字的颜色(可选)
```

Here is a demo:

```markdown
哪个英文字母最酷？ {% hideInline 因为西装裤(C装酷),查看答案,#FF7242,#fff %}

门里站着一个人? {% hideInline 闪 %}
```

哪个英文字母最酷？ {% hideInline 因为西装裤(C装酷),查看答案,#FF7242,#fff %}

门里站着一个人? {% hideInline 闪 %}

#### Block hide

block独立的block隐藏内容，可以隐藏很多内容，包括图片，代码块等等

( display 不能包含英文逗号，可用&sbquo;)

```
{% hideBlock display,bg,color %}
content
{% endhideBlock %}
```

Here is a demo:

```markdown
查看答案
{% hideBlock 查看答案 %}
傻子，怎么可能有答案
{% endhideBlock %}
```



查看答案
{% hideBlock 查看答案 %}
傻子，怎么可能有答案
{% endhideBlock %}

#### Toggle hide

如果你需要展示的内容太多，可以把它隐藏在收缩框里，需要时再把它展开。

( display 不能包含英文逗号，可用&sbquo;)

```markdown
{% hideToggle display,bg,color %}
content
{% endhideToggle %}
```

```
{% hideToggle Butterfly安装方法 %}
在你的博客根目录里

git clone -b master https://github.com/jerryc127/hexo-theme-butterfly.git themes/Butterfly

如果想要安装比较新的dev分支，可以

git clone -b dev https://github.com/jerryc127/hexo-theme-butterfly.git themes/Butterfly

{% endhideToggle %}

```

{% hideToggle Butterfly安装方法 %}
在你的博客根目录里

git clone -b master https://github.com/jerryc127/hexo-theme-butterfly.git themes/Butterfly

如果想要安装比较新的dev分支，可以

git clone -b dev https://github.com/jerryc127/hexo-theme-butterfly.git themes/Butterfly

{% endhideToggle %}



### Tabs 

```
{% tabs Unique name, [index] %}
<!-- tab [Tab caption] [@icon] -->
Any content (support inline tags too).
<!-- endtab -->
{% endtabs %}

Unique name   : Unique name of tabs block tag without comma.
                Will be used in #id's as prefix for each tab with their index numbers.
                If there are whitespaces in name, for generate #id all whitespaces will replaced by dashes.
                Only for current url of post/page must be unique!
[index]       : Index number of active tab.
                If not specified, first tab (1) will be selected.
                If index is -1, no tab will be selected. It's will be something like spoiler.
                Optional parameter.
[Tab caption] : Caption of current tab.
                If not caption specified, unique name with tab index suffix will be used as caption of tab.
                If not caption specified, but specified icon, caption will empty.
                Optional parameter.
[@icon]       : FontAwesome icon name (full-name, look like 'fas fa-font')
                Can be specified with or without space; e.g. 'Tab caption @icon' similar to 'Tab caption@icon'.
                Optional parameter.
```

An example 4: customized tabs with icons and tab name:

```markdown
{% tabs test4 %}
<!-- tab 第一个Tab -->
**tab名字为第一个Tab**
<!-- endtab -->

<!-- tab @fab fa-apple-pay -->
**只有图标 没有Tab名字**
<!-- endtab -->

<!-- tab 炸弹@fas fa-bomb -->
**名字+icon**
<!-- endtab -->
{% endtabs %}

```

{% tabs test4 %}
<!-- tab 第一个Tab -->
**tab名字为第一个Tab**
<!-- endtab -->

<!-- tab @fab fa-apple-pay -->
**只有图标 没有Tab名字**
<!-- endtab -->

<!-- tab 炸弹@fas fa-bomb -->
**名字+icon**
<!-- endtab -->
{% endtabs %}

### More tab plugin functions

There are more functions like **Button**, **inline image**, and **label**. 

```markdown
{% label text color %}
可选 背景颜色，默认为 default
default/blue/pink/red/purple/orange/green
```

Here is a demo:

```
臣亮言：{% label 先帝 %}创业未半，而{% label 中道崩殂 blue %}。今天下三分，{% label 益州疲敝 pink %}，此诚{% label 危急存亡之秋 red %}也！然侍衞之臣，不懈于内；{% label 忠志之士 purple %}，忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气；不宜妄自菲薄，引喻失义，以塞忠谏之路也。
宫中、府中，俱为一体；陟罚臧否，不宜异同。若有{% label 作奸 orange %}、{% label 犯科 green %}，及为忠善者，宜付有司，论其刑赏，以昭陛下平明之治；不宜偏私，使内外异法也。

```

臣亮言：{% label 先帝 %}创业未半，而{% label 中道崩殂 blue %}。今天下三分，{% label 益州疲敝 pink %}，此诚{% label 危急存亡之秋 red %}也！然侍衞之臣，不懈于内；{% label 忠志之士 purple %}，忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气；不宜妄自菲薄，引喻失义，以塞忠谏之路也。
宫中、府中，俱为一体；陟罚臧否，不宜异同。若有{% label 作奸 orange %}、{% label 犯科 green %}，及为忠善者，宜付有司，论其刑赏，以昭陛下平明之治；不宜偏私，使内外异法也。

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
