import { createStore, applyMiddleware } from 'redux';
import { persistStore, persistReducer } from 'redux-persist'
import thunkMiddleware from 'redux-thunk';
import GambitApp from '../reducers/rootReducer'
import storage from 'redux-persist/lib/storage' // defaults to localStorage for web

const persistConfig = {
  key: 'root',
  storage,
}

const persistedReducer = persistReducer(persistConfig, GambitApp)

export const store = createStore(persistedReducer);
export const persistor = persistStore(store)
