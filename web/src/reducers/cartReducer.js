import { combineReducers } from 'redux';
import { GET_NUMBER_CART, ADD_CART, DECREASE_QUANTITY, INCREASE_QUANTITY, DELETE_CART } from './cartAction';

const initProduct = {
  numberCart: 0,
  carts: [],
_products: []
}

const todoProduct = (state = initProduct, action) => {
  switch (action.type) {
    case GET_NUMBER_CART:
      return {
        ...state
      }
    case ADD_CART:
      let cart = {
        id: action.payload.id,
        qty: 1,
        title: action.payload.title,
        image: action.payload.image,
        price: action.payload.price
      }
      state.carts.push(cart);
      return {
        ...state,
        numberCart: state.numberCart + 1
      }
    case INCREASE_QUANTITY:
      state.numberCart++
      state.carts[action.payload].quantity++;

      return {
        ...state
      }
    case DECREASE_QUANTITY:
      let quantity = state.carts[action.payload].qty;
      if (quantity > 1) {
        state.numberCart--;
        state.carts[action.payload].quantity--;
      }

      return {
        ...state
      }
    case DELETE_CART:
      return {
        ...state,
        numberCart: state.numberCart - 1,
        carts: state.carts.filter(item => {
          return (item.id !== action.payload.id)
        })

      }
    default:
      return state;
  }
}

export default todoProduct;
