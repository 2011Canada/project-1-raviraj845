
const credentials = {
    action:"nofilter"//this is the same as below
    
}

async function allReimb(){
   // e.preventDefault();
    try{

        let res = await fetch("http://localhost:8080/projectservlet/finance",{
            method:"GET",
            //body: JSON.stringify(credentials),
            headers:{
                
                "Content-Type" : "application/json"
            }
        });

        let user = await res.json()
        let x=`<tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last name</th>
        <th>Amount</th>
        <th>Submitted</th>
        <th>Resolved</th>
        <th>Description</th>
        <th>Status</th>
        <th>Approve</th>
        <th>Deny</th>
      </tr>`;
        for(let i =0; i< user.length;i++){
            x+=`<tr>
            <td>`+user[i].reimb_id+`</td>
            <td>`+user[i].user_first_name+`</td>
            <td>`+user[i].user_last_name+`</td>
            <td>`+user[i].reimb_amount+`</td>
            <td>`+user[i].ts+`</td>
            <td>`+user[i].rs+`</td>
            <td>`+user[i].reimb_description+`</td>
            <td>`+user[i].reimb_status+`</td>
            <td><input type="submit" value="Approve" onclick="approveReimb(${user[i].reimb_id})"></td>
            <td><input type="submit" value="Deny" onclick="denyReimb(${user[i].reimb_id})"></td>
          </tr>`;
        }
document.getElementById('customers').innerHTML=x;
        console.log(user);
    } catch( e) {
        console.log(e);
    }


}
allReimb();

async function approveReimb(reimbid1){
  const credentials = {
    action:"update",//this is the same as below
    typeId:null,
    statusId:1,
    reimb_id:reimbid1
}

try{

    let res = await fetch("http://localhost:8080/projectservlet/finance",{
        method:"POST",
        body: JSON.stringify(credentials),
        headers:{
            "Content-Type" : "application/json"
        }
    })

    let user = await res.json()
    console.log(user);
} catch( e) {
    console.log(e);
}

}

async function denyReimb(reimbid1){
  const credentials = {
    action:"update",//this is the same as below
    typeId:null,
    statusId:3,
    reimb_id:reimbid1
}

try{

    let res = await fetch("http://localhost:8080/projectservlet/finance",{
        method:"POST",
        body: JSON.stringify(credentials),
        headers:{
            "Content-Type" : "application/json"
        }
    })

    let user = await res.json()
    console.log(user);
} catch( e) {
    console.log(e);
}

}



async function filterReimb(){
  let x = document.getElementById('status').value;
  if(x==0){
    allReimb();
    return;
  }
  const credentials = {
    action:"filter",//this is the same as below
    typeId:null,
    statusId:x,
    reimb_id:null
}

try{

    let res = await fetch("http://localhost:8080/projectservlet/finance",{
        method:"POST",
        body: JSON.stringify(credentials),
        headers:{
            "Content-Type" : "application/json"
        }
    })

    let user = await res.json()
    let x=`<tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last name</th>
        <th>Amount</th>
        <th>Submitted</th>
        <th>Resolved</th>
        <th>Description</th>
        <th>Status</th>
        <th>Approve</th>
        <th>Deny</th>
      </tr>`;
        for(let i =0; i< user.length;i++){
            x+=`<tr>
            <td>`+user[i].reimb_id+`</td>
            <td>`+user[i].user_first_name+`</td>
            <td>`+user[i].user_last_name+`</td>
            <td>`+user[i].reimb_amount+`</td>
            <td>`+user[i].ts+`</td>
            <td>`+user[i].rs+`</td>
            <td>`+user[i].reimb_description+`</td>
            <td>`+user[i].reimb_status+`</td>
            <td><input type="submit" value="Approve" onclick="approveReimb(${user[i].reimb_id})"></td>
            <td><input type="submit" value="Deny" onclick="denyReimb(${user[i].reimb_id})"></td>
          </tr>`;
        }
document.getElementById('customers').innerHTML=x;
    console.log(user);
} catch( e) {
    console.log(e);
}

}

function redirect() {
    window.location.replace("login.html");
    return false;
  }