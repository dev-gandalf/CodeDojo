window.addEventListener("scroll", onScroll);

const addButton = document.querySelector(".add");
const input = document.querySelector(".input-group");


function deleteInput() {
	this.parentElement.remove();
}

function addInput(e) {
	e.preventDefault();
	if (document.querySelector(".input-group").childElementCount < 11) {
		const name = document.createElement("input");
		name.type = "file";
		name.id = "files";
		name.className = "flex";
		name.name = "file";
		name.accept = "image/jpeg, image/png, image/jpg";

		const button = document.createElement("a");
		button.className = "delete";
		button.innerHTML = "&times";

		button.addEventListener("click", deleteInput);

		const flex = document.createElement("div");
		flex.className = "flex";

		input.appendChild(flex);
		flex.appendChild(name);
		flex.appendChild(button);
	}

}

addButton.addEventListener("click", addInput);
/*=================================================================*/

onScroll();
function onScroll() {
	activateMenuAtCurrentSection(home);
	activateMenuAtCurrentSection(services);
	activateMenuAtCurrentSection(about);
	activateMenuAtCurrentSection(contact);
}

function activateMenuAtCurrentSection(section) {
	const targetLine = scrollY + innerHeight / 2;

	// check if session passed the line
	// what data do I need?
	const sectionTop = section.offsetTop;
	const sectionHeight = section.offsetHeight;
	const sectionTopReachOrPassedTargetline = targetLine >= sectionTop;

	// check if the base is under the target line

	const sectionEndsAt = sectionTop + sectionHeight;
	const sectionEndPassedTargetline = sectionEndsAt <= targetLine;

	// session boundaries
	const sectionBoundaries =
		sectionTopReachOrPassedTargetline && !sectionEndPassedTargetline;

	const sectionId = section.getAttribute("id");
	const menuElement = document.querySelector(`.menu a[href*=${sectionId}]`);

	menuElement.classList.remove("active");
	if (sectionBoundaries) {
		menuElement.classList.add("active");
	}
}

function openMenu() {
	document.body.classList.add("menu-expanded");
}

function closeMenu() {
	document.body.classList.remove("menu-expanded");
}

ScrollReveal({
	origin: "top",
	distance: "30px",
	duration: 700,
}).reveal(`
  #home, 
  #home img, 
  #home .stats, 
  #services,
  #services header,
  #services .card
  #about, 
  #about header, 
  #about .content`);