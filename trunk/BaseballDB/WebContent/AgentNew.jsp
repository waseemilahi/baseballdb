
<HTML>
<HEAD>
<TITLE>Create New Agent</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!--
function validateForm()
{
var count=0;
var msg="";

    for(i=0;i<=4;i++)
    {
        if(document.UD.elements[i].value=="")
        {
        count=1;
        msg=msg+"\n"+document.UD.elements[i].name;
        }
        else if((i>3) && (count==0))
        {
            return(true);
        }
    }
    for(i=0;i<=4;i++)
    {
        if(document.UD.elements[i].value=="")
        {
        alert("PLEASE FILL IN THE FOLLOWING FIELD(S)\n "+msg);
        document.UD.elements[i].focus();
        return(false);
        }

    }


}
//-->
</SCRIPT>
</HEAD>

<BODY>
<CENTER>
<FONT SIZE="5" COLOR="#006600" FACE="verdana">Create New Agent</FONT>
</CENTER><BR><BR>
<FORM METHOD=POST ACTION="DBChangeServlet">
<TABLE ALIGN="CENTER">

<TR> 
	<TD>Name</TD>
    <TD><INPUT TYPE="TEXT" NAME="NAME" maxlength = "20"></TD> 
</TR>
<TR>
    <TD>Address</TD>
    <TD><INPUT TYPE="TEXT" NAME="ADDRESS" maxlength = "50"></TD>
</TR>
<TR>
    <TD>Corporation</TD>
    <TD><INPUT TYPE="TEXT" NAME="CORPORATION" maxlength = "20"></TD>
</TR>
<TR>
    <TD>
    <input type="SUBMIT" name="DBChange" value="agent create submit"   
    onClick="return validateForm()"></TD>
    <TD><INPUT TYPE="RESET" VALUE="Reset"></TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>

