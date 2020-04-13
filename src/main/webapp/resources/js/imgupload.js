let upload = document.querySelector('.sell_image_box1 div')
let upload2 = document.querySelector('.sell_image_box1')
let image = document.querySelector(".sell_image_box2");
let imageAll = document.getElementsByClassName("sell_image_box2");


upload.addEventListener('change', function(e){
    console.log(imageAll)
    if(imageAll.length > 8){
        alert("사진 업로드는 8개 까지 입니다")
    }else{

    var get_file = e.target.files;

    var img = document.createElement('img');

    var box = document.createElement('div');

    var box3 =document.createElement('button');

    box.className = 'sell_image_box2'

    box3.type = 'button';

    box3.innerText ="X"

    box3.addEventListener('click',function(){
        
        upload2.removeChild(box)
        
    })

    var reader = new FileReader;

    reader.onload = (function(aimg){
        return function(e){
            aimg.src = e.target.result;
        }    
    })(img)

    if(get_file){

        reader.readAsDataURL(get_file[0]);
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
})


