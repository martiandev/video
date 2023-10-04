function handleLogin(event){
    event.preventDefault();
    const email = document.getElementById("email");
    const password = document.getElementById("password");

    const user = {
        email: email,
        password: password
    }
    fetch(
        'http://localhost:8080/api/v1/users/login',{
            method:'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify(user)
        }
    ).then(
        response =>{
            if(!response.ok){
                alert('Login Failed');
            }
            return response.json();
        }
    ).then( (response) => {
        localStorage.setItem('connectUser',JSON.stringify(response));
        window.location.href = 'index.html';
    }

    );
}


const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit",handleLogin);