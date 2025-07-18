// $(document).ready(function () {});
$(function () {
  // const h1 = document.querySelector("h1");
  // const pList = document.querySelectorAll("p");
  // h1.style.color = "blue";
  // for (p of pList) {
  // p.style.color = "white";
  // p.style.backgroundColor = "tomato";
  // }

  //제이쿼리 방식
  $("h1").css("color", "blue");
  $("p").css({
    color: "white",
    "background-color": "tomato",
  });
  $("p").first().css("font-size", "4rem");
  $("p").last().css("color", "yellow");
  $("p:eq(2)").text("eq로 다시 글 작성합니다");
  $(".wrap").children().css({ color: "deeppink", border: "2px solid" });
  $(".wrap").find("h1").css({ color: "orange" });
  $("h1").siblings("p").css("background-color", "navy");
});
