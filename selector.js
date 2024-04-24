let barSelector = document.getElementById("selectorBar");
let closeButton = document.getElementById("closeButton");
var downloadList = [];
var alreadyCOllected = false;
let downloadButton = document.getElementById("download");


closeButton.addEventListener("click", fnc =>{
    barSelector.style.display = "none";
});
document.addEventListener("click", function(ev){
    if(ev.target.textContent == "Selecionar"){
        barSelector.style.display = "block";
    }
});


downloadButton.addEventListener("click", fnc =>{
    for(let i=0;i<downloadList.length;i++){
        fetch(downloadList[i]).then(response => response.blob()).then(blob => {
            let newBlob = window.URL.createObjectURL(blob);
            let a = document.createElement("a");
            console.log(downloadList[i])
            a.download = downloadList[i].replace(/^.*[\\\/]/,'');
            a.href = newBlob;
            document.body.appendChild(a);
            a.click();
            a.remove();
        })
    }
})
document.addEventListener("click", function(){
    downloadList.length >= 1 ? closeButton.innerHTML = "Remover" : closeButton.innerHTML = "Fechar";
})
document.addEventListener("click",function(ev){
    let event = ev.target;
    if(event.parentNode.id == "selectorBar"){
        event.parentNode.removeChild(event);
        downloadList.pop(event.src);
    }
    if (event.classList.contains("figuras") && !downloadList.includes(event.src)){
        let src = ev.target.src;
        let img = barSelector.appendChild(document.createElement("img"));
        img.src = src;
        img.style.width = "100px";
        img.style.height = "100px";
        downloadList.push(src);
    }
})

