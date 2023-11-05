import React from "react";
import { Navbar, NavbarBrand, Nav, NavItem, NavLink, Button } from "reactstrap";
import { Icon } from "@iconify/react";
import { useNavigate } from "react-router-dom";

export const Header = ({ title }) => {
  const navigate = useNavigate();
  return (
    <Navbar className="navBar">
      <NavbarBrand>
        <Icon
          icon="bxs:book"
          style={{ fontSize: "50px", marginRight: "10px" }}
          onClick={() => {
            navigate("/search");
            window.location.reload();
          }}
        />
        <Button
          size="lg"
          outline
          onClick={() => {
            navigate("/profile/myCourses");
            window.location.reload();
          }}
        >
          My courses
        </Button>
      </NavbarBrand>
      <Nav className="mr-auto" navbar>
        <NavItem>
          <h1>{title}</h1>
        </NavItem>
      </Nav>
      <Nav className="mr-auto" navbar>
        <NavItem>
          <Icon
            icon="mdi:bell-outline"
            style={{ fontSize: "50px" }}
            onClick={() => console.log("show notifications pop up")}
          />
          <Icon
            icon="fluent:chat-16-regular"
            style={{ fontSize: "50px" }}
            onClick={() => console.log("open chat")}
          />
          <Icon
            icon="iconoir:profile-circle"
            style={{ fontSize: "50px" }}
            onClick={() => {
              navigate("/profile/myCourses");
              window.location.reload();
            }}
          />
        </NavItem>
      </Nav>
    </Navbar>
  );
};
