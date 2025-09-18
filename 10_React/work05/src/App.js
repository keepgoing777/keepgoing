import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let [users, setUsers] = useState([])
  let [name, setName] = useState('')
  let [age, setAge] = useState('')

  let addUser = ()=>{
    if( name.trim() && age.trim() ){
      setUsers( [...users, { name, age }] )
      setName('')
      setAge('')
    }
  }

  let userDel = ( index )=>{
    //filter는 배열을 순회하면서 조건에 맞는 요소만 골라서 새로운 배열을 만드는 함수
    //fileter함수는 최대 두 개의 인자를 가지는데,
    //첫번째 인자 res는 배열의 i번째 요소( 사용하지 않는다면 _로 지정 )
    //두번째 인자 i는 배열의 index
    let newUser = users.filter( (res, i)=> i !== index  );
    setUsers( newUser );
  }

  return (
    <div className="App">
      <input value={name}
             onChange={(e)=>{ setName(e.target.value) }}
             placeholder='이름을 입력하세요'/>

      <br/>

      <input value={age}
             onChange={ (e)=>{ setAge(e.target.value) } }
             placeholder='나이를 입력하세요'/>

      <br/>

      <input type="button" value="확인" onClick={ addUser }/>

      <br/>

      <table border='1'>
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>비고</th>
        </tr>

        {
          users.map(
            (u, index)=>(
              <tr>
                <td>{u.name}</td>
                <td>{u.age}</td>
                <td>
                  <input type="button" value="삭제" onClick={ ()=>{ userDel(index) } }/>
                </td>
              </tr>
            )
          )
        }

      </table>

    </div>
  );
}

export default App;























