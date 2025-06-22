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
});
