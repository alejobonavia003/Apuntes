import React from "react";

const dato = new Date();

const year = dato.getFullYear();

function Footer() {
    return <footer>
        <p>@copyrigth Bonavia {year}</p>
    </footer>;
}

export default Footer;