window.addEventListener("load",(()=>{let e=!1;const t=function(){var t;document.body.style.cssText="width: 100%;overflow: hidden",document.querySelector("#local-search .search-dialog").style.display="block",document.querySelector("#local-search-input input").focus(),btf.fadeIn(document.getElementById("search-mask"),.5),e||(t=GLOBAL_CONFIG.localSearch.path,fetch(GLOBAL_CONFIG.root+t).then((e=>e.text())).then((e=>(new window.DOMParser).parseFromString(e,"text/xml"))).then((e=>{const t=[...e.querySelectorAll("entry")].map((function(e){const t=e.querySelector("content");return{title:e.querySelector("title").textContent,content:t?t.textContent:"",url:e.querySelector("url").textContent}})),n=document.querySelector("#local-search-input input"),c=document.getElementById("local-search-results");n.addEventListener("input",(function(){let e='<div class="search-result-list">';const n=this.value.trim().toLowerCase().split(/[\s]+/);if(c.innerHTML="",this.value.trim().length<=0)return;let o=0;t.forEach((function(t){let c=!0;t.title&&""!==t.title.trim()||(t.title="Untitled");let r=t.title.trim().toLowerCase();const l=t.content.trim().replace(/<[^>]+>/g,"").toLowerCase(),s=t.url.startsWith("/")?t.url:GLOBAL_CONFIG.root+t.url;let a=-1,i=-1,d=-1;if(""!==r||""!==l?n.forEach((function(e,t){a=r.indexOf(e),i=l.indexOf(e),a<0&&i<0?c=!1:(i<0&&(i=0),0===t&&(d=i))})):c=!1,c){const c=t.content.trim().replace(/<[^>]+>/g,"");if(d>=0){let t=d-30,a=d+100;t<0&&(t=0),0===t&&(a=100),a>c.length&&(a=c.length);let i=c.substring(t,a);n.forEach((function(e){const t=new RegExp(e,"gi");i=i.replace(t,'<span class="search-keyword">'+e+"</span>"),r=r.replace(t,'<span class="search-keyword">'+e+"</span>")})),e+='<div class="local-search__hit-item"><a href="'+s+'" class="search-result-title">'+r+"</a>",o+=1,""!==l&&(e+='<p class="search-result">'+i+"...</p>")}e+="</div>"}})),0===o&&(e+='<div id="local-search__hits-empty">'+GLOBAL_CONFIG.localSearch.languages.hits_empty.replace(/\$\{query}/,this.value.trim())+"</div>"),e+="</div>",c.innerHTML=e,window.pjax&&window.pjax.refresh(c)}))})),e=!0),document.addEventListener("keydown",(function e(t){"Escape"===t.code&&(n(),document.removeEventListener("keydown",e))}))},n=function(){document.body.style.cssText="width: '';overflow: ''";const e=document.querySelector("#local-search .search-dialog");e.style.animation="search_close .5s",setTimeout((()=>{e.style.cssText="display: none; animation: ''"}),500),btf.fadeOut(document.getElementById("search-mask"),.5)},c=()=>{document.querySelector("#search-button > .search").addEventListener("click",t),document.getElementById("search-mask").addEventListener("click",n),document.querySelector("#local-search .search-close-button").addEventListener("click",n)};c(),window.addEventListener("pjax:complete",(function(){"block"===getComputedStyle(document.querySelector("#local-search .search-dialog")).display&&n(),c()}))}));