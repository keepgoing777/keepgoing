const signup = document.querySelector("#signup");
let check1 = false; //userID
let check2 = false; //password
let check3 = false; //passwordCheck
let check4 = false; //userName
let check5 = false; //email
let check6 = false; //phone

//signup.disabled = false;

const userId = document.querySelector("#userId");
const userSpan = document.querySelector("#userId+span");
const userRegExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
userId.addEventListener("input", (e) => {
  if (userRegExp.test(e.target.value)) {
    userSpan.innerHTML = "OK!";
    userSpan.style.color = "green";
    check1 = true;
  } else if (e.target.value === "") {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "black";
    check1 = false;
  } else {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "red";
    check1 = false;
  }
  /* if (check1 && check2 && check3 && check4 && check5 && check6){
    signup.disabled = false;
  } */
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const password = document.querySelector("#password");
const passwordSpan = document.querySelector("#password+span");
const passwordCheck = document.querySelector("#passwordCheck");
const passwordCheckSpan = document.querySelector("#passwordCheck+span");

const passRegExp =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
password.addEventListener("input", (e) => {
  if (passRegExp.test(e.target.value)) {
    passwordSpan.innerHTML = "OK!";
    passwordSpan.style.color = "green";
    check2 = true;
  } else if (e.target.value === "") {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "black";
    check2 = false;
  } else {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "red";
    check2 = false;

    signup.disabled = !(
      check1 &&
      check2 &&
      check3 &&
      check4 &&
      check5 &&
      check6
    );
  }

  if (passwordCheck.value === e.target.value) {
    passwordCheckSpan.innerHTML = "OK";
    passwordCheckSpan.style.color = "green";
    check3 = true;
  } else {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
    check3 = false;
    signup.disabled = !(
      check1 &&
      check2 &&
      check3 &&
      check4 &&
      check5 &&
      check6
    );
  }
});

passwordCheck.addEventListener("input", (e) => {
  if (passRegExp.test(password.value) && password.value === e.target.value) {
    passwordCheckSpan.innerHTML = "OK!";
    passwordCheckSpan.style.color = "green";
    check3 = true;
  } else if (e.target.value === "") {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "black";
    check3 = false;
  } else {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
    check3 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const userName = document.querySelector("#userName");
const userNameSpan = document.querySelector("#userName+span");
const userNameRegExp = /^[가-힣]{2,}$/;
userName.addEventListener("input", (e) => {
  if (userNameRegExp.test(e.target.value)) {
    userNameSpan.innerHTML = "OK!";
    userNameSpan.style.color = "green";
    check4 = true;
  } else if (e.target.value === "") {
    userNameSpan.innerHTML = "한글 2자 이상";
    userNameSpan.style.color = "black";
    check4 = false;
  } else {
    userNameSpan.innerHTML = "한글 2자 이상";
    userNameSpan.style.color = "red";
    check4 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const email = document.querySelector("#email");
const emailSpan = document.querySelector("#email+span");
const emailRegExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
email.addEventListener("input", (e) => {
  if (emailRegExp.test(e.target.value)) {
    emailSpan.innerHTML = "OK!";
    emailSpan.style.color = "green";
    check5 = true;
  } else if (e.target.value === "") {
    emailSpan.innerHTML = "이메일 형식";
    emailSpan.style.color = "black";
    check5 = false;
  } else {
    emailSpan.innerHTML = "이메일 형식";
    emailSpan.style.color = "red";
    check5 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const phone = document.querySelector("#phone");
const phoneSpan = document.querySelector("#phone+span");
const phoneRegExp = /^010-\d{4}-\d{4}$/;
phone.addEventListener("input", (e) => {
  if (phoneRegExp.test(e.target.value)) {
    phoneSpan.innerHTML = "OK!";
    phoneSpan.style.color = "green";
    check6 = true;
  } else if (e.target.value === "") {
    phoneSpan.innerHTML = "젼화번호 형식";
    phoneSpan.style.color = "black";
    check6 = false;
  } else {
    phoneSpan.innerHTML = "젼화번호 형식";
    phoneSpan.style.color = "red";
    check6 = false;
  }
  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12 이내";
  userSpan.style.color = "black";

  passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
  passwordSpan.style.color = "black";

  passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
  passwordCheckSpan.style.color = "black";

  userNameSpan.innerHTML = "한글 2자 이상";
  userNameSpan.style.color = "black";

  emailSpan.innerHTML = "이메일 형식";
  emailSpan.style.color = "black";

  phoneSpan.innerHTML = "전화번호 형식";
  phoneSpan.style.color = "black";
});
