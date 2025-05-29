const click = document.querySelector("section button:first-child");
const img = document.querySelectorAll("img");
const span = document.querySelector("button span");
const h2 = document.querySelector("h2");
const restart = document.querySelector("section button:last-child");
console.log(click);
// click 이벤트를 걸어야 하는 애
console.log(img);
// click 했을 때 바꿔야 하는 애
let count = 0;
const game = () => {
  const random = [
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
    //   1부터 3까지 랜덤값이 필요함 spy 다음 1,2,3만 바뀌면 이미지 바뀌니까
  ];
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `asset/spy${random[i]}.jpg`);
  }
  console.log(count);
  span.innerHTML = ++count;
  //클릭할때마다 카운트 증가

  if (random[0] === random[1] && random[1] === random[2]) {
    click.disabled = true;
    //click.setAttribute("disabled", true);
    //click.setAttribute("disabled", "disabled");
    h2.style.visibility = "visible";
  }
  //이미지 3개가 일치한 경우 버튼 disabled 처리
  //h2에 visibility: visible로 변경
};
const end = () => {
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `asset/spy${i + 1}.jpg`);
  }
  count = 0;
  span.innerHTML = "";
  h2.style.visibility = "hidden";
  click.disabled = false;
  // 이미지는 처음 그대로 1 2 3 순서대로 보이게 하고
  // count는 0으로 바꾸고 span은 비우고
  // visibility hidden 처리
};
click.addEventListener("click", game);
restart.addEventListener("click", end);
//reload.location : 번쩍임으로 거의 안씀
