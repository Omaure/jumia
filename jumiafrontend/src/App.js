import './App.css';
import 'mdbreact/dist/css/mdb.css';
import React, {useEffect, useState} from "react";
import axios from "axios";
import {MDBTable, MDBTableBody, MDBTableHead, MDBInput} from 'mdbreact';

function App() {
    const [allPhones, setPhones] = useState([]);

    useEffect(() => {
        getPhoneByCountryName();
    }, []);

    useEffect(() => {

    }, [allPhones]);

    const getPhoneByCountryName = (countryName) => {
        console.log(countryName)
        axios.get('http://localhost:8088/phones', {
            params: {
                country: countryName
            }
        })
            .then((res) => {
                console.log(res.data);
                if (res.data.error) {
                    console.log("error");
                } else {
                    setPhones(res.data.customerPhonesList);
                }
            })
    };

    return (
        <div>
            <MDBInput label="Material input" onChange={(e => {getPhoneByCountryName(e.target.value)})}/>
            <MDBTable>
                <MDBTableHead color="primary-color" textWhite>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Phone</th>
                    </tr>
                </MDBTableHead>
                <MDBTableBody>
                    {allPhones.map((currentPhone) => {
                        return (
                            <tr>
                                <td>{currentPhone.id}</td>
                                <td>{currentPhone.name}</td>
                                <td>{currentPhone.phone}</td>
                            </tr>
                        )
                    })}
                </MDBTableBody>
            </MDBTable>
        </div>


    );
}

export default App;
