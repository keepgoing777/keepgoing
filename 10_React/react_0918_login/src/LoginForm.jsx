import React, { useState } from "react";

const User = {
  email: "test@a.com",
  pw: "1111",
};

const LoginForm = () => {
  const [isLogin, setLogin] = useState(false);
  const [email, setEmail] = useState("");
  const [pw, setPw] = useState("");
  const [emailValid, setEmailValid] = useState(false);
  const [pwValid, setPwValid] = useState(false);

  // 이메일 입력을 확인하는 감지자 생성
  const handlerEmail = (e) => {
    setEmail(e.target.value);
    if (e.target.value == "") {
      setEmailValid(false);
    } else {
      setEmailValid(true);
    }
  };

  // 비밀번호 입력을 확인하는 감지자 생성
  const handlerPw = (e) => {
    setPw(e.target.value);
    if (e.target.value == "") {
      setPwValid(false);
    } else {
      setPwValid(true);
    }
  };

  const clickConfirm = () => {
    if (email === User.email && pw === User.pw) {
      setLogin(true);
    } else {
      alert("로그인 실패!");
    }
  };
  return (
    <div className="page">
      <div className="titleWrap">
        이메일과 비밀번호를
        <br />
        입력해주세요
      </div>

      <div className="contentWrap">
        <div className="inputTitle">이메일 주소</div>
        <div className="inputWrap">
          <input
            className="input"
            placeholder="이메일을 입력하세요"
            value={email}
            onChange={handlerEmail}
          />
        </div>

        <div className="errorMessageWrap">
          {!emailValid && <div>이메일 주소를 입력해야합니다 </div>}
        </div>
        <div className="inputTitle">비밀번호</div>
        <div className="inputWrap">
          <input
            className="input"
            placeholder="비밀번호를 입력하세요"
            value={pw}
            onChange={handlerPw}
          />
        </div>
        <div className="errorMessageWrap">
          {!pwValid && <div>비밀번호를 입력해야합니다</div>}
        </div>
        <div>
          <button className="bottombutton" onClick={clickConfirm}>
            확인
          </button>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
