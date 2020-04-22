let upload = document.querySelector('.sell_image_box1 div')
let upload2 = document.querySelector('.sell_image_box1')
let image = document.querySelector(".sell_image_box2");
let imageAll = document.getElementsByClassName("sell_image_box2");


upload.addEventListener('change', function (e) {
    
    var get_file = e.target.files;
    if (imageAll.length + get_file.length > 9) {
        alert("사진 업로드는 8개 까지 입니다")
    } else {
        for (var i = 0; i < get_file.length; i++) {
            var img = document.createElement('img');

            var box = document.createElement('div');

            var box3 = document.createElement('button');

            box.className = 'sell_image_box2'

            box3.type = 'button';

            box3.innerText = "X"

            box3.addEventListener('click', function (e) {

                e.target.parentNode.remove(box)


            })

            var reader = new FileReader;

            reader.onload = (function (aimg) {
                return function (e) {
                    aimg.src = e.target.result;

                }
            })(img)

            if (get_file) {
                reader.readAsDataURL(get_file[i]);

            }

            image.appendChild(img);
            box.appendChild(img);
            upload2.appendChild(box);
            box.appendChild(box3);


            box.style.display = "block";
            img.style.width = 202 + "px"
            img.style.height = 202 + "px"
            box.style.color = "white"
        }
    }
})


var catebtn = document.querySelectorAll(".sell_category_container .sell_category_container_ul ul li ")
var catebtn2 = document.querySelector(".sell_category_container .cate1 span")
var catebtn3 = document.querySelector(".sell_category_container .cate1")


function clickBtnHandler(e) {
    for (var i = 0; i < catebtn.length; i++) {
        catebtn[i].classList.remove('red')
    }
    console.log(this.childNodes)
    this.classList.add('red')
    catebtn3.style.display = "block"
    catebtn2.innerText = this.childNodes[0].value;

}
for (var j = 0; j < catebtn.length; j++) {
    catebtn[j].addEventListener('click', clickBtnHandler);
    
}

var comma = document.querySelector(".sell_price_container div input");

function insertComma(num) {
    if (num.length <= 3) {
        return num;
    }
    var count = Math.ceil(num.length / 3);
    var newNum = [];
    for (var i = 0; i < count; i++) {
        newNum.unshift(num.slice(-3 * (i + 1), num.length - (3 * i)));
    }
    return newNum.join(',');
}


comma.addEventListener('keyup', function () {
    this.value = insertComma(this.value.replace(/[,]/g, ''))
});




var inputs = document.querySelectorAll('.sell_category_container_ul ul li input')

    function a (e){
    for (var i = 0; i < inputs.length; i++) {
        
    }
    e.target.innerText =
    console.log(e.target.value)
}

for (var j = 0; j < inputs.length; j++) {
    var category = inputs[j].addEventListener('click', a);
}



