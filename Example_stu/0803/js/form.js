var userId=document.querySelector("#user-id");
var pw1=document.querySelector("#user-pw1");
var pw2=document.querySelector("#user-pw2");


userId.onChange=checkId;
pw1.onChange=checkPw;
pw2.onChange=comparePw;

function checkId(){
    if(userId.value.length<4 || userId.value.length>15){
        alert("4~15자리 영문과 숫자를 사용하세요.");
        userId.select(); //select : 재입력할 수 있도록 필드 다시 선택
    }
}

function checkPw(){         //JS에서 value사용
    if(pw1.value.length<8){ //a.value == a와 같다고 보면됨,, 
        alert("비밀번호는 8자리 이상이여야 합니다.");
        pw1.value="";
        pw1.focus();
    }
}

function comparePw(){
    if(pw1.value!=pw2.value){
        alert("비밀번호가 다릅니다. 다시 입력해주세요");
        pw2.value="";
        pw2.focus();
    }
}