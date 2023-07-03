import "./App.css";
import MainRouter from "./Routes/MainRouter";
import { GoogleOAuthProvider } from '@react-oauth/google';

function App() {
  return (
    <>
    <GoogleOAuthProvider clientId="441165277837-au5r6861cete3r0v1i7c8ldsgjmlsors.apps.googleusercontent.com">
    <MainRouter/>
    </GoogleOAuthProvider>
    </>
  );
}

export default App;
