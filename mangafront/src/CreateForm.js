import React from 'react';

const CreateForm = props => {
    return(
        <div>
           <form onSubmit={props.submitForm}>
               <label htmlFor="username">Username:
               <input
                    type="text"
                    placeholder="username"
                    label="username"
                    vale={props.username}
                    onChange={props.handleNameChange}
                />
                </label>

                <label htmlFor="email"> Email:
                <input
                    type="text"
                    placeholder="email"
                    label="email"
                    value={props.email}
                    onChange={props.handleEmailChange}/>
                />
                </label>

                <label htmlFor="password"> Password:
                <input
                        type="text"
                        placeholder="password"
                        label="password"
                        value={props.password}
                        onChange={props.handlePasswordChange} />
                    />
                </label>
                <input type="submit" value="create"/>
               </form> 
        </div>
    )
}

export default CreateForm;