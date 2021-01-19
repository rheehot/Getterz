import React, { useCallback } from "react";
import { useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import DefaultHeadBar from "../Layout/DefaultHeadBar";
import DefaultBodyPaper from "../Layout/DefaultBodyPaper";
import DefaultFootBar from "../Layout/DefaultFootBar";
import SignupBody from "./SignupBody";

export default function Signup() {
  const { header, loading } = useSelector((state) => ({
    header: state.SellerInfo.header,
    loading: state.SellerInfo.loading,
  }));
  const history = useHistory();
  const redirecTo = useCallback(() => history.push("/seller"), [history]);
  if (!loading && header.session) {
    redirecTo();
  }
  return (
    <div>
      <DefaultHeadBar />
      <DefaultBodyPaper Body={<SignupBody />} />
      <DefaultFootBar />
    </div>
  );
}
