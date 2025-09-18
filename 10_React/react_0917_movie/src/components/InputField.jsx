import React from "react";

const InputField = 
( { value, placeholder, onChange, errorMessage } ) =>{
    return(
        <div>
            <input placeholder={placeholder}
                   value={value}
                   onChange={onChange}/>

            <br/>

            <div style={{color:'red'}}>{errorMessage}</div>    

        </div>
    )
}

export default InputField;