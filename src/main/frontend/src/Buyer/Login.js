import React, { useCallback } from "react";
import { useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import DefaultHeadBar from "../Layout/DefaultHeadBar";
import DefaultBodyPaper from "../Layout/DefaultBodyPaper";
import DefaultFootBar from "../Layout/DefaultFootBar";
import LoginBody from "./LoginBody";

export default function Login() {
  const { loading, header } = useSelector((state) => ({
    loading: state.BuyerInfo.loading,
    header: state.BuyerInfo.header,
  }));
  const history = useHistory();
  const redirecTo = useCallback(() => history.push("/buyer"), [history]);
  if (!loading && header.session) {
    redirecTo();
  }
  return (
    <>
      <DefaultHeadBar />
      <DefaultBodyPaper Body={<LoginBody />} />
      <DefaultFootBar />
    </>
  );
}
