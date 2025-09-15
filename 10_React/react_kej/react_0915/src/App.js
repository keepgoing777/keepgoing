import logo from "./logo.svg";

function App() {
  let topic = [
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "my css" },
    { id: 3, title: "java script", body: "your js" },
  ];

  return (
    <div className="App">
      <Header
        title="React"
        onChangeMode={(id) => {
          alert("id:" + id);
        }}
      ></Header>
      <Nav
        topics={topic}
        onChangeMode={(id) => {
          alert("id" + id);
        }}
      ></Nav>
      <Article title="Welcome" body="hello, web"></Article>
      <Article title="i am title" body="i am body"></Article>
      <Child name="Hello, John"></Child>
    </div>
  );
}

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={function (event) {
            // a 태그의 기본인 기본동작 방지(url로 넘어가는것을 방지)
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
    //lis.push(<li> <a href={"/read/" + t.id}> / {t.title} / {t.body} </a> </li>
    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={function (event) {
            event.preventDefault();
            props.onChangeMonde(event.target.id);
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

function Child(props) {
  return <h2>{props.name}</h2>;
}
export default App;
