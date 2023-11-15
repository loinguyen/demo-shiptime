import React, { Component } from "react";
 import PropTypes from "prop-types";

 class MobileNavBar extends Component {
   constructor(props) {
     super(props);
     this.state = {};
   }
   render() {
     return (
       <div
         className={
           this.props.activeClass ? "hamburger_menu active" : "hamburger_menu"
         }
       >
         <div className="hamburger_close" onClick={this.props.onClose}>
           <i className="fa fa-times" aria-hidden="true"></i>
         </div>
         <div className="hamburger_menu_content text-right">
           <ul className="menu_top_nav">
             <li className="menu_item">
               <a href="#">
                 My Account
               </a>
             </li>
             <li className="menu_item">
               <a href="#">About Us</a>
             </li>
           </ul>
         </div>
       </div>
     );
   }
 }
 MobileNavBar.propTypes = {
   activeClass: PropTypes.bool,
   onClose: PropTypes.func,
 };
 
 export default MobileNavBar;
 