// 그래서, 로그인이 되어 있는건지 아닌지 상태 확인먼저 함
// 로그인되어있다면 name값 바로 출력
//const info = localStorage.getItem("name");
//if (info) {
//  document.body.innerHTML = `
// <h1>${info}님 환영합니다!</h1>
// <button type="button" id="logout">로그아웃</button></div>
//`;
//}

// 코드 중복 함수로 기능으로

const show = (name) => {
  document.body.innerHTML = `
  <h1>${name}님 환영합니다!</h1>
  <button type="button" id="logout">로그아웃</button></div>
  `;
  const logout = document.querySelector("#logout");
  logout.addEventListener("Click", () => {
    localStorage.removeItem("name");
    location.reload();
  });
};

const info = localStorage.getItem("name");
if (info) {
  show(info);
}

//  1. login 눌렀을 때 클릭 이벤트 걸기
login.addEventListener("click", () => {
  // 아이디 입력값, 비밀번호 입력값들 로그인 처리
  // 로그인 성공하고 이름을 저장, 그리고 다시 출력
  if (username.value === "" && password.value === "") {
    alert("이름과 비밀번호를 입력해주세요");
    return; //함수 이 부분에서 끝내겠다는 뜻
  }
  localStorage.setItem("name", username.value);

  // ~님 환영합니다 문구 + 로그아웃 버튼
  show(username.value);

  //   다시 창을 끄고 들어갔을 때 자동 로그인이 되어있어야 하는데 안되어있고 이름만 저장되어있음.
});
