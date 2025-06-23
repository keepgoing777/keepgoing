window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    alert("클릭");
    click.style.background = "hotpink";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블클릭");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    alert("우클릭");
    event.preventDefault();
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    hover.style.background = "lightblue";
    hover.textContent = "Mouse Enter!";
  });

  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    inputResult.innerHTML = e.target.value;
    //e.target.value; = 현재 입력값을 가져옴
  });

  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.innerHTML = e.target.value;
  });

  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    if (inputText.value === " ") e.preventDefault();
    alert("제출불가");
  });

  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyReult");
  keyboard.addEventListener("keydown", (e) => {
    keyResult.innerHTML = e.key;
    console.log(e.key);
    //e.key = 키보드 키 누른 값
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });

  const move = document.querySelector(".movebox");
  let x = 0,
    y = 0;
  document.addEventListener;
});
