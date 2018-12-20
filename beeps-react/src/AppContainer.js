import React from 'react';
import { Link } from 'react-router-dom';

const AppContainer = (props) => {
    return (<div>
        <div>
            <Link to='/'>Home</Link> |&nbsp;
            <Link to='/countries'>Products</Link> |&nbsp;
            <Link to={`/countries/${127}`}>Product by no</Link> |&nbsp;
        </div>
        {props.children}
    </div>);
};

export default AppContainer;

