function showDetail() {
    document.querySelector('#desc').style.display="block";
    document.querySelector('#open').style.display="none";
}

function hideDetail() {
    document.querySelector('#desc').style.display="none"; /*hidden: 자리 차지 ㅇ, none: 자리차지 x*/ 
    document.querySelector('#open').style.display="block";
}