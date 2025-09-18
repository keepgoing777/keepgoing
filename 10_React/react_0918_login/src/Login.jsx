import React, { use, useState } from "react";
import LoginForm from "./LoginForm";
import MainPage from "./MainPage";

export default function Login() {
  const [isLogin, setLogin] = useState(false);
  const [email, setEmail] = useState("");

  return <div> {isLogin ? <MainPage email={email} /> : <LoginForm />}</div>;
}

