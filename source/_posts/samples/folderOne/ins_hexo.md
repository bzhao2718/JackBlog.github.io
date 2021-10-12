## Some Links

Here is doc [next theme](https://theme-next.js.org/).

And the [classless-hexo](https://github.com/fiatjaf/classless-hexo) theme.

[hexo renderer pandoc](https://github.com/wzpan/hexo-renderer-pandoc).

### Setup pluggins

Here is a [tutorial of setting up Hexo next theme](https://jdhao.github.io/2017/02/26/hexo-install-use-issue/).

Generate ssh keys.

Here are some commands used to install some pluggins

This [tutorial mentions setup MathJax to enable copy latex code](https://yanghaowang.github.io/posts/20201125-LaTex-Display-in-Hexo).



## Hexo Themes

Some themes

## notes

### 1. Download nvm and upgrade npm. Download hexo-cli and dependencies

download and use node version manager [nvm github](https://github.com/nvm-sh/nvm#manual-install)
```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
```

```
nvm install node --lts
nvm use node --lts
```
```
npm install -g npm
npm install -g hexo-cli

hexo init hexo-blog # this will create a hexo-blog
cd hexo-blog
npm install
```

```
# replace the default renderer
hexo uninstall hexo-renderer-marked --save
hexo install hexo-renderer-pandoc --save

```

### 2. Set up a GitHub repo and GitHub pages for serving the posts

Create a GitHub repo: https://github.com/bzhao2718/BlogTwoTest.github.io.git

Then create an empty folder and run `hexo init emptyFolder` then run `cd emptyFolder and npm install`.

Then connect this folder to the remote GitHub repo:

```
echo "# BlogTwoTest.github.io" >> README.md
git init
git add README.md
git add .
git commit -m "first commit"
git branch -M master # rename
git remote add origin https://github.com/bzhao2718/BlogTwoTest.github.io.git
git push -u origin master
```

### Generate and run commands

```
hexo generate # generate all posts
hexo server # make posts available at http://localhost:4000
```

### Deploy using git

Deploy instructions:  [One-Command Deployment | Hexo](https://hexo.io/docs/one-command-deployment.html) 

I think `ssh` keys are already set up at this point on my machine.

The command `hexo deploy` is used to deploy the site to the server.

First download the dependency  [hexojs/hexo-deployer-git: Git deployer plugin for Hexo.](https://github.com/hexojs/hexo-deployer-git) 

```
$ npm install hexo-deployer-git --save

# then modify _config file as following:

# Deployment
## Docs: https://hexo.io/docs/one-command-deployment
deploy:
  type: 'git'
  repo: https://github.com/bzhao2718/BlogTwoTest.github.io
  branch: master
```

Make sure the BlogTwoTest repo is public for free account.

```
hexo clean && hexo deploy
```

Then in the repo settings -> GitHub Pages tab, there will be a reminder :  Your site is ready to be published at https://bzhao2718.github.io/BlogTwoTest.github.io/

Also, I created a `gh-pages` branch and set this brach as the GitHub Pages source.

If you use the default publishing source for your GitHub Pages site, your site will publish automatically. You can also choose to publish your site from a different branch or folder. Before you configure a publishing source, make sure the branch you want to use as your publishing source already exists in your repository.

> GitHub Pages will use Jekyll to build your site by default. If you want to use a static site generator other than Jekyll, disable the Jekyll build process by creating an empty file called `.nojekyll` in the root of your publishing source, then follow your static site generator's instructions to build your site locally.
>
> – from this [post](https://docs.github.com/en/pages/getting-started-with-github-pages/about-github-pages).

>Navigate to your repository settings and change the “Pages” branch to `gh-pages` (or the branch specified in your config). The deployed site should be live on the link shown on the “Pages” setting.



### Use Pandoc as the renderer

Make sure pandoc is downloaded.

In the hexo root folder. Download the Hexo-renderer-pandoc, instructions:  [wzpan/hexo-renderer-pandoc: A pandoc-markdown-flavor renderer for hexo.](https://github.com/wzpan/hexo-renderer-pandoc) 

```
npm install hexo-renderer-pandoc --save

```

```
  # renderer pandoc
pandoc:
    filters:
      # - pandoc-crossref
    extra:
      - citeproc:
      - filter: pandoc-crossref
      - bibliography: "source/referenceAll.bib"
    template:
    meta:
    # mathEngine: katex
    # by default, pandoc uses mathjax
    # also, using pandoc as the markdown renderer will pose some issues related to post tags
    
    ## it seems that without this mathjax pluggin the equations are not rendered 
    ## download instructions: https://github.com/next-theme/hexo-filter-mathjax
    mathjax:
      tags: none # or 'ams' or 'all'
      single_dollars: true # enable single dollar signs as in-line math delimiters
      cjk_width: 0.9 # relative CJK char width
      normal_width: 0.6 # relative normal (monospace) width
      append_css: true # add CSS to pages rendered by MathJax
      every_page: true # if true, every page will be rendered by MathJax regardless the `mathjax` setting in Front-matter
```



Change this in the package.json and package_lock.json to remove the marked renderer setting:

`        "hexo-renderer-marked": "^4.0.0",`.

### Add hexo Next theme

Instructions from this post:  [next-theme/hexo-theme-next: 🎉 Elegant and powerful theme for Hexo.](https://github.com/next-theme/hexo-theme-next) 

Modify theme config file:

```
# Installed through npm
cp node_modules/hexo-theme-next/_config.yml _config.next.yml
# Installed through Git
cp themes/next/_config.yml _config.next.yml

```

With this way, all your configurations locate in main site config file. You don't need to edit theme config file or create any new files. But you need to **[keep up indentation](https://theme-next.js.org/docs/troubleshooting.html#Keep-Up-Indentation)** within `theme_config` option.

MathJax

```
npm un hexo-renderer-marked
npm i hexo-renderer-pandoc

```

To enable mathjax, go the the next theme setting :

```
math:
  # Default (false) will load mathjax / katex script on demand.
  # That is it only render those page which has `mathjax: true` in front-matter.
  # If you set it to true, it will load mathjax / katex script EVERY PAGE.
  every_page: true

  mathjax:
    enable: true
    # Available values: none | ams | all
    tags: none
```

Remember to set the every_page to true if not included in the source file. Also set the mathjax: enable to true as well.

### Cross reference to other files (anchor)

Use this plugin:  [tcatche/hexo-filter-link-post: Transfer relative post link in markdown file to post link. 将文件里的通过相对路径引用的 markdown 文件转为对应的文章的链接](https://github.com/tcatche/hexo-filter-link-post) 

```
npm install hexo-filter-link-post --save
[Referrence: bar](./bar.md#title)
# also supports Task lists {#task_list_id}
then refer to it using the manualy set id.
```

