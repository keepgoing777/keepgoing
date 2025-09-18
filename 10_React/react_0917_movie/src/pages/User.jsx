import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import Spinner from "../components/Spinner";
import UserList from "../components/UserList";

const User = () => {
   
    const [user, setUser] = useState(null)
    //const [users, setUsers] = useState([])
    const [loading, setLoading] = useState(true)
    const {id} = useParams();
    //alert( "id:" + id )

    useEffect( ()=>{
        //웹에 준비되어 있는 유저 정보를 가져온다
        axios.get( 'https://jsonplaceholder.typicode.com/users/' + id )
             .then( response => { 
                    setUser( response.data )
                    setLoading(false) //로드 종료
            } );
    } )

    const userDetail = loading ? <Spinner/> : (
        <div>
            <div>{ user.name }</div>
            <div>{ user.email }</div>
            <div>{ user.phone }</div>
        </div>
    )

    return(
        <div>
            <h1>유저정보</h1>

            { userDetail }
        </div>
    )

}

export default User;