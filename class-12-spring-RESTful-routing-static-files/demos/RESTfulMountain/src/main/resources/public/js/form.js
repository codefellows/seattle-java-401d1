const HOMEPAGE = "http://localhost:9090/mountains";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("delete-mountain");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
        method: "DELETE"
    }).then(() => {
        window.location = HOMEPAGE;
    });
});

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
    console.log(ev.target.method, ev.target.action);

    const inputs = ev.target.getElementsByTagName("input");
    const name = inputs[0].value;
    const elevation = inputs[1].value;
    const mountain = {name, elevation};
    const body = JSON.stringify(mountain);

    fetch(ev.target.action, {
        method: ev.target.getAttribute("method"),
        body: body
    }).then(() => {
        window.location = HOMEPAGE;
    });
})
