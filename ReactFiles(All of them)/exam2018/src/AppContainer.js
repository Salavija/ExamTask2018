import React from 'react';
import { Link } from 'react-router-dom';

const AppContainer = (props) => {
    return (<div>
        <div>
            <Link to='/'>Home</Link> |&nbsp;
            <Link to='/products'>Products</Link> |&nbsp;
            <Link to={`/products/${127}`}>Product by no</Link> |&nbsp;
            <Link to='/help'>help</Link> |&nbsp;
            <Link to='/non-existant'>Non Existant</Link>
        </div>
        {props.children}
    </div>);
};

export default AppContainer;

