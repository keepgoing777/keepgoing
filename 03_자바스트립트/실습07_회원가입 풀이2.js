const signup = document.querySelector("#signup");
const fields = [
  {
    id: "userId",
    exp: /^[a-zA-Z][a-zA-Z0-9]{3,11}$/,
    message: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
  },
  {
    id: "password",
    exp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
    message: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
  },
  {
    id: "passwordCheck",
    message: "위 비밀번호와 동일하게",
  },
  {
    id: "userName",
    exp: /^[가-힣]{2,}$/,
    message: "한글 2자 이상",
  },
  {
    id: "email",
    exp: /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/,
    message: "이메일 형식",
  },
  {
    id: "phone",
    exp: /^010-\d{4}-\d{4}$/,
    message: "전화번호 형식",
  },
];

const validCheck = () => {
  let check = true; // 모든 필드가 유효하다고 가정
  fields.forEach(({ id }) => {
    const input = document.querySelector.apply(`#${id}`);
    if (input.value === "") {
      check = false;
    } else if (id !== "passwrodCheck" && !exp?.test(input.value)) {
      check = false;
    }
    if (id === "password" && passwordCheck.value !== input.value) {
      check = false;
    }
  });
  return check;
};

fields.forEach(({ id, exp, message }) => {
  const input = document.querySelector(`#${id}`);
  const span = document.querySelector(`#${id}+span`);
  const regExp = exp;
  const password = document.querySelector("#password");
  const passRegExp = fields[1].exp;
  input.addEventListener("input", (e) => {
    if (
      (id === "passwordCheck" &&
        passRegExp.test(password.value) &&
        password.value === e.target.value) ||
      (exp !== undefined && regExp?.test(e.targetget.value)) // ? null이 아닐때만 처리
    ) {
      span.innerHTML = "OK!";
      span.style.color = "green";
    } else if (e.target.value === "") {
      span.innerHTML = message;
      span.style.color = "black";
    } else {
      span.innerHTML = message;
      span.style.color = "red";
    }

    // password
    const passwordCheck = document.querySelector("#passwordCheck");
    const passwordCheckSpan = document.querySelector("#passwordCheck+span");
    if (id === "password") {
      if (passwordCheck.value === e.target.value) {
        passwordCheckSpan.innerHTML = "OK";
        passwordCheckSpan.style.color = "green";
        fields[2].check = true;
      } else {
        passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
        passwordCheckSpan.style.color = "red";
        fields[2].check = false;
      }
    }

    // every : 배열 안에 특정 조건이 모두 만족할 경우 true
    signup.disabled = !validCheck();
  });
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  fields.forEach(({ id, message }) => {
    const span = document.querySelector.apply(`#${id}+span`);
    span.innerHTML = message;
    span.style.color = "black";
  });
});
