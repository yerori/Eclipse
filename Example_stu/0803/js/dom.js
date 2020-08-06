var bigPic=document.querySelector("#cup"); //큰 이미지 가져오긔
var smallPic=document.querySelectorAll(".small") //작은 이미지 가져온다.
                    //querySelectorAll : 여러개 해당, querySelector는 하나만!!

for(var i=0; i<smallPic.length;i++){
   
    smallPic[i].onclick=changePic; 
}

function changePic(){
    var newPic = this.src; // 지금(this) 클릭한 것의 주소
    bigPic.setAttribute("src",newPic); //newPic값을 큰 이미지의 src속성(주소)에 할당
}

var isOpen=false;
var view=document.querySelector("#view");
view.addEventListener("click",function(){
    if(isOpen==false){
        document.querySelector("#detail").style.display="block";
        view.innerText="상세 설명 닫기";
        isOpen=true;
    }else{
        document.querySelector("#detail").style.display="none";
        view.innerText="상세 설명 보기";
        isOpen=false;
    }
});