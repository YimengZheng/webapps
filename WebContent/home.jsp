<%@include file="head.jsp"  %>

<div id="p_up">
<fieldset id="person" style="border:none" >
  <table width="670" border="0">
    <tr>
      <td colspan="3" rowspan="2" align="center"><img src="image/default_head.jpg" width="130" height="130" /></td>
      <td width="288" rowspan="3"><p>Name</p>
        <p>Location</p>
        <p>About Me</p></td>
      <td width="48">&nbsp;</td>
      <td width="66">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="77">News</td>
      <td width="87">Following</td>
      <td width="78">Follower</td>
      <td><form id="form2" name="form2" method="post" action="">
        <input type="submit" name="p_edit" id="button" value="edit" style="background:#2B7BA2; color:#fff;"  />
      </form></td>
      <td><form id="form2" name="form2" method="post" action="">
        <input type="submit" name="d_mess" id="d_mess" value="Message" style="background:#2B7BA2; color:#fff;" />
      </form></td>
    </tr>
  </table>
</fieldset>
</div>

<div id="p_down_l">
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:16px"><strong>&nbsp;&nbsp;&nbsp;Following</strong></p>
<fieldset id="p_following" >

  <form id="form3" name="form3" method="post" action="">
    <p align="right"><input type="submit" name="m_following" id="m_following" value="More" style="background:#2B7BA2; color:#fff; border-style:hidden" /></p>
  </form>
</fieldset>
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:16px"><strong>&nbsp;&nbsp;&nbsp;Follower</strong></p>
<fieldset id="p_follower" >
<form id="form3" name="form3" method="post" action="">
    <p align="right"><input type="submit" name="p_follower" id="p_follower" value="More" style="background:#2B7BA2; color:#fff; border-style:hidden" /></p>
  </form>
</fieldset>
</div>

<div id="p_down_r">
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:18px"><strong>&nbsp;&nbsp;&nbsp;NEWS</strong></p>
<fieldset id="p_news" >
NEWS
  
</fieldset>
</div>

</body>
</html>