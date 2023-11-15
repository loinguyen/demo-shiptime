import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import MobileNavBar from "./MobileNavBar";
import device, { size } from "../../modules/mediaQuery";
import MediaQuery from "react-responsive";

class NavBar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      modalShow: false,
      activeclass: false,
    };
  }

  componentDidMount() {
    window.addEventListener("scroll", this.resizeHeaderOnScroll);
  }

  resizeHeaderOnScroll() {
    const distanceY = window.pageYOffset || document.documentElement.scrollTop,
      shrinkOn = 100,
      headerEl = document.getElementById("navbar");

    if (distanceY > shrinkOn) {
      headerEl.classList.add("navShrink");
    } else {
      headerEl.classList.remove("navShrink");
    }
  }

  showHideModal = () => {
    this.setState({ modalShow: !this.state.modalShow });
  };

  handleMenuClicked = () => {
    this.setState({ activeclass: !this.state.activeclass });
  };
  render() {
    // const { cart } = this.props;

    return (
      <header className="header trans_300">
        <div className="main_nav_container">
          <div className="container">
            <div className="row">
              <div className="col-lg-12 text-right">
                <div className="logo_container logo_img_header">
                  <Link to="/">
                    <img style={{height: '100%'}} src="../../shiptime-logo.svg" alt="Ship Time"/>
                  </Link>
                </div>
                <nav className="navbar" id="navbar">
                  <ul className="navbar_menu">
                    <li>
                      <a href="contact.html" >About Us</a>
                    </li>
                  </ul>
                  <ul className="navbar_user">
                    <li>
                      <a href="#">
                        <i className="fa fa-user" aria-hidden="true"></i>
                      </a>
                    </li>
                  </ul>
                  <div
                    className="hamburger_container"
                    onClick={() => this.handleMenuClicked()}
                  >
                    <i className="fa fa-bars" aria-hidden="true"></i>
                  </div>
                </nav>
              </div>
            </div>
          </div>
          <MediaQuery query={device.max.tabletL}>
            <MobileNavBar
              activeClass={this.state.activeclass}
              onClose={() => this.handleMenuClicked()}
            />
          </MediaQuery>
        </div>
      </header>
    );
  }
}

const mapStateToProps = state =>{
  return{
      numberCart:state._todoProduct.numberCart,
      cart: state._todoProduct.carts
  }
}
export default connect(mapStateToProps,null)(NavBar)
