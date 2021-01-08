


async function allReimb(){
    const credentials = {
        empAction:"disp",
        ers_users_id:localStorage.getItem("newuserid"),
        amount:null,
        description:null,
        typeId:null
     
        
    }
    try{

        let res = await fetch("http://localhost:8080/projectservlet/employee",{
            method:"POST",
            body: JSON.stringify(credentials),
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
            </tr>`;
        }
document.getElementById('customers').innerHTML=x;
        console.log(user);
    } catch( e) {
        console.log(e);
    }
}
allReimb();


async function addReimb(amount,description,typeId,ers_users_id){
    const credentials = {
     empAction:"ins",
     ers_users_id:ers_users_id,
	 amount:amount,
	 description:description,
	 typeId:typeId
  }
  
  try{
  
      let res = await fetch("http://localhost:8080/projectservlet/employee",{
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
$('#sub').on('click',function(){
    let typ = $('#typeReimb').val();
    let amt = $('#amount').val();
    let descrip = $('#desc').val();
    addReimb(amt,descrip,typ,localStorage.getItem("newuserid"));
});
// $('#div2').on('click',function(){
//     $('.myDiv2').show();
//     $('.myDiv').hide();

// });

function redirect() {
    window.location.replace("login.html");
    return false;
  }