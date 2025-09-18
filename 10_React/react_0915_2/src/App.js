import logo from "./logo.svg";
import { useState } from "react";

function App() {
  // let mode = "READ"; App - Header와 Nav alert 창 대신 mode넣어도 클릭 비활성화
  let [mode, setMode] = useState("WELCOME");
  let [id, setId] = useState(null);

  let m_topics = [
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "your css" },
    { id: 3, title: "java script", body: "our js" },
  ];

  let content = null;
  if (mode === "WELCOME") {
    content = <Article title="welcome mode state" body="STATE WEB"></Article>;
  } else if (mode === "READ") {
    let title = null;
    let body = null;

    for (let i = 0; i < m_topics.length; i++) {
      if (m_topics[i].id === id) {
        title = m_topics[i].title;
        body = m_topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
  }

  return (
    <div className="App">
      <Header
        title="React!!"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        topics={m_topics}
        onChangeMode={(id) => {
          setMode("READ");
          setId(id);
        }}
      ></Nav>
      <Article title="Welcome" body="hello, react web!"></Article>
      {content}
    </div>
  );
}

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={() => {
            alert("헤더");
          }}
        >
          {props.title}
        </a>
      </h1>
      <h1>
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  let lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];

    lis.push(
      <li>
        <a
          href={"/read/" + t.id}
          id={t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
          }}
        >
          {t.title} / {t.body}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

export default App;
