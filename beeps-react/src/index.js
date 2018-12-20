import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import AppContainer from './AppContainer';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Products from "./components/Products";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

const NoMatch = (props) => {
    var goApp = () => props.history.push("/");
    return <div>Route did not match
    <button onClick={goApp}>Go Home</button></div>;
};


ReactDOM.render((
    <BrowserRouter>
        <AppContainer>
            <Switch>
                <Route exact path='/' component={App} />
                <Route path="/products/:id" component={Products.id} />
                < Route path="/products" component={Products} />
                <Route path="*" component={NoMatch} />
                <Route component={NoMatch} />
            </Switch>
        </AppContainer>
    </BrowserRouter>
), document.getElementById('root'));
// ReactDOM.render(<App />, document.getElementById('root'));
