var sign = document.querySelector('#signup');

var func = function () {
    var userid = document.querySelector('#userId');
    var pw = document.querySelector('#password');
    var userpw = document.querySelector('#userconfirm');
    var name = document.querySelector('#name');
    var nName = document.querySelector('#nickname');
    var hp = document.querySelector('#hp');


    var regul1 = /^[a-zA-Z0-9]{4,12}$/; //비밀번호
    var regul2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/; //이메일
    var regul3 = /^[가-힝a-zA-Z]{2,}$/; // 이름
    let regul4 = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/; //핸드폰번호
    //let regul5 = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\*]{4,8}+$/; //닉네임//



    if (userid.value === "") {
        alert('email을 입력하세요')
        userid.focus();
        return false;
    }

    if (!regul2.test(userid.value)) {
        alert('이메일 형식을 지켜주세요')
        return false;
    }

    if (pw.value === "") {
        alert('비밀번호를 입력하세요')
        pw.focus();
        return false;
    }

    if (!regul1.test(pw.value)) {
        alert('비밀번호는 4~12자리입니다!')
        return false;
    }

    if (pw.value != userpw.value) {
        alert('비밀번호가 일치하지 않습니다')
    }

    if (name.value === "") {
        alert('이름을 입력하세요')
        name.focus();
        return false
    }

    if (!regul3.test(name.value)) {
        alert('올바른 이름의 형식이 아닙니다')
        return false
    }

    if (nName.value === "") {
        alert('닉네임을 입력하세요!')
        nName.focus();
        return false
    }

    /*if (!regul5.test(nName.value)) {
        alert('올바른 닉네임 형식이 아닙니다')
        return false
    }*/

    if (hp.value === "") {
        alert('핸드폰번호를 입력하세요!')
        hp.focus();
        return false
    }

    if (!regul4.test(hp.value)) {
        alert('올바른 핸드폰번호의 형식이 아닙니다')
        return false
    }
    
    alert("정상적으로 등록되셨습니다");
}

sign.addEventListener('click', func);