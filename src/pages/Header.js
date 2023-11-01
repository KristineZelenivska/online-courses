import React from "react";
import { Navbar, NavbarBrand, Nav, NavItem, NavLink, Button } from "reactstrap";
import { Icon } from "@iconify/react";

export const Header = () => (
  <Navbar className="navBar">
    <NavbarBrand>
      <Icon
        icon="bxs:book"
        style={{ fontSize: "50px", marginRight: "10px" }}
        onClick={() => console.log("Go to search page")}
      />
      <Button
        size="lg"
        outline
        onClick={() => console.log("Go to My courses page")}
      >
        My courses
      </Button>
    </NavbarBrand>
    <Nav className="mr-auto" navbar>
      <NavItem>
        <h1>Search Course</h1>
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
          onClick={() => console.log("open Profile")}
        />
      </NavItem>
    </Nav>
  </Navbar>
);
