// JS code for DoubleGumApi

function initDoubleGumApi() {
    
    let lib = {};
    
    lib.TicketType = function(id, name, weight, deprecated) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.deprecated = deprecated;
    }


    lib.TicketType.prototype.getId = function() {
        return this.id;
    }

    lib.TicketType.prototype.getName = function() {
        return this.name;
    }

    lib.TicketType.prototype.getWeight = function() {
        return this.weight;
    }

    lib.TicketType.prototype.getDeprecated = function() {
        return this.deprecated;
    }

    lib.TicketType.prototype.setId = function(id) {
        this.id = id;
    }

    lib.TicketType.prototype.setName = function(name) {
        this.name = name;
    }

    lib.TicketType.prototype.setWeight = function(weight) {
        this.weight = weight;
    }

    lib.TicketType.prototype.setDeprecated = function(deprecated) {
        this.deprecated = deprecated;
    }
    
    lib.TicketStatus = function(id, name){
        this.id = id;
        this.name = name;
    }

    lib.TicketStatus.prototype.getId = function() {
        return this.id;
    }

    lib.TicketStatus.prototype.getName = function() {
        return this.name;
    }

    lib.TicketStatus.prototype.setId = function(id) {
        this.id = id;
    }

    lib.TicketStatus.prototype.setName = function(name) {
        this.name = name;
    }

    lib.Ticket = function(id, x, y, email, description, picture, type, status) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.email = email;
        this.description = description;
        this.picture = picture;
        this.type = type;
        this.status = status;
    }

    lib.Ticket.prototype.getId = function(){
        return this.id;
    }

    lib.Ticket.prototype.getX = function(){
        return this.x;
    }

    lib.Ticket.prototype.getY = function() {
        return this.y;
    }

    lib.Ticket.prototype.getEmail = function() {
        return this.email;
    }

    lib.Ticket.prototype.getDescription = function(){
        return this.description;
    }

    lib.Ticket.prototype.getPicture = function() {
        return this.picture;
    }

    lib.Ticket.prototype.getType = function() {
        return type;
    }

    lib.Ticket.prototype.getStatus = function() {
        return this.status;
    }
    return lib;
}
