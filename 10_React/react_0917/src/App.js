import { useState } from 'react';
import logo from './logo.svg';

function App() {

  let [fruit, setFruit] = useState([]);
  let [inputVal, setInputVal] = useState('');

  function addFruit(){
    if( inputVal.trim() ){
      setFruit( [ ...fruit, inputVal ] )
      setInputVal('');
    }
  }

  return (
    <div className="App">
      
      <input type="text"
             value={inputVal}
             onChange={ 
              (e)=>{ setInputVal( e.target.value ) } 
             }
             placeholder='좋아하는 과일'/>

      <input type="button" value="확인" onClick={addFruit}/>

      <ul>
        {
          fruit.map( (f)=>( 
                      <li>{f}</li> 
                     ) )
        }
      </ul>

    </div>
  );
}

export default App;
