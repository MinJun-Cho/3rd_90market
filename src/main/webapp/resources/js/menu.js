var menu = document.querySelector('.menu i');
var menu2 = document.querySelector('.menu ul');



menu.addEventListener('mouseover',function(){
    menu2.style.display = "inline-block";
    menu.style.color = "red"
});


menu.addEventListener('mouseout',function(){
    menu2.style.display = "none";
    menu.style.color = "black"
});

menu2.addEventListener('mouseover',function(){
    menu2.style.display = "inline-block";
    menu.style.color = "red"
});


menu2.addEventListener('mouseout',function(){
    menu2.style.display = "none";
    menu.style.color = "black"
});